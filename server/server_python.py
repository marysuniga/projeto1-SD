import grpc
from concurrent import futures
import threading
import queue
import time
from server import message_pb2
from server import message_pb2_grpc
import os

channels = {}
channel_types = {}

# configuracoes para omitir logs do grpc
os.environ["GRPC_VERBOSITY"] = "NONE"
os.environ["GRPC_TRACE"] = ""

class MessengerServicer(message_pb2_grpc.MessengerServicer):
    def __init__(self):
        self.lock = threading.Lock()
        self.load_existing_channels()  # Load existing channels from files on startup

    
    def load_existing_channels(self):  # New method to load channels from files
        if not os.path.exists('channels'):
            os.makedirs('channels')
        for filename in os.listdir('channels'):
            print(f"Backup de canal encontrado: {filename}")
            if filename.endswith(".txt"):
                channel_name = filename[:-4]  # Remove the .txt extension
                self.create_channel(channel_name, message_pb2.UNARY)
                file_path = os.path.join('channels', filename)
                with open(file_path, "r") as file:
                    for message in file:
                        if channel_types[channel_name] == message_pb2.UNARY:
                            channels[channel_name].put(message.strip())  
                        elif channel_types[channel_name] == message_pb2.STREAMING:
                            for q in channels[channel_name]:  
                                q.put(message.strip())
                        print(f"mensagem inserida em {channel_name}: {message}")

    def create_channel(self, name, channel_type):
        with self.lock:
            if name in channels:
                print(f"Canal {name} já existe.")
                return
            if channel_type == message_pb2.UNARY:
                channels[name] = queue.Queue()
                channel_types[name] = message_pb2.UNARY
            elif channel_type == message_pb2.STREAMING:
                channels[name] = []
                channel_types[name] = message_pb2.STREAMING
            else:
                print("Tipo de canal inválido. Por favor, insira 0 para UNARY ou 1 para STREAMING.")
                return
            if not os.path.exists(os.path.join('channels', f"{name}.txt")):
                open(os.path.join('channels', f"{name}.txt"), "w").close()
                print(f"Canal {name} do tipo {channel_type} criado.")


    def delete_channel(self, name):
        if name in channels:
            del channels[name]
            del channel_types[name]
            print(f"Canal {name} removido.")

        else:
            print("Nao foi possivel remover. Canal nao encontrado.")
            return
        
    def _remove_message_from_file(self, channel, message):
        file_path = os.path.join('channels', f"{channel}.txt")
        if os.path.exists(file_path):
            with open(file_path, "r") as file:
                lines = file.readlines()

            with open(file_path, "w") as file:
                for line in lines:
                    if line.strip() != message:
                        file.write(line)

    def GetChannels(self, request, context):
        with self.lock:
            return message_pb2.ChannelList(channels=list(channels.keys()))

    def GetChannelInfo(self, request, context):
        channel = request.channel
        with self.lock:
            if channel not in channels:
                context.abort(grpc.StatusCode.INVALID_ARGUMENT, "Canal não encontrado.")
            return message_pb2.ChannelInfo(name=channel, type=channel_types[channel])

    def ReceiveMessage(self, request, context):
        channel = request.channel
        if channel not in channels or channel_types[channel] != message_pb2.UNARY:
            context.abort(grpc.StatusCode.INVALID_ARGUMENT, "Canal inválido ou não-unário especificado.")
        while True:
            try:
                message = channels[channel].get(timeout=1)
                self._remove_message_from_file(channel, message)
                return message_pb2.MessageResponse(message=message)
            except queue.Empty:
                if not context.is_active():
                    context.abort(grpc.StatusCode.CANCELLED, "Cliente desconectado")
                continue

    def StreamMessages(self, request, context):
        channel = request.channel
        if channel not in channels or channel_types[channel] != message_pb2.STREAMING:
            context.abort(grpc.StatusCode.INVALID_ARGUMENT, "Canal inválido ou não-streaming especificado.")
        q = queue.Queue()
        with self.lock:
            channels[channel].append(q)
        try:
            while True:
                message = q.get()
                response = message_pb2.MessageResponse(message=message)
                self._remove_message_from_file(channel, message)
                yield response
        except grpc.RpcError as e:
            print(f"Cliente desconectado: {e}")
            with self.lock:
                channels[channel].remove(q)

    def PostMessage(self, request, context):
        channel = request.channel
        message = request.message
        if channel in channels:
            #### armazena mensagem em disco
            with open(os.path.join('channels', f"{channel}.txt"), "a") as file:
                file.write(f"{message}\n")
        print("sending...")
        time.sleep(2)
        with self.lock:
            if channel not in channels:
                context.abort(grpc.StatusCode.INVALID_ARGUMENT, "Canal não encontrado.")
            if channel_types[channel] == message_pb2.UNARY:
                channels[channel].put(message)
            elif channel_types[channel] == message_pb2.STREAMING:
                for client in channels[channel]:
                    client.put(message)
        
        return message_pb2.Empty()

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    servicer = MessengerServicer()
    message_pb2_grpc.add_MessengerServicer_to_server(servicer, server)
    server.add_insecure_port('[::]:50000')
    server.start()
    print("Servidor iniciado na porta 50000")

    def input_thread():
        while True:
            action = input("Digite C para criar um canal ou R para remover um canal:")
            if action == "C" or action == "c":
                channel_name = input("Digite o nome do canal: ")
                channel_type = int(input("Digite o tipo de canal (0 para UNARY, 1 para STREAMING): "))
                servicer.create_channel(channel_name, channel_type)
            elif action == "R" or action == "r":
                print("Canais: {}".format(channels.keys()))
                channel_name = input("Digite o nome do canal a ser removido: ")
                servicer.delete_channel(channel_name)
            else:
                print("Ação inválida.")

    thread = threading.Thread(target=input_thread, daemon=True)
    thread.start()

    try:
        while True:
            time.sleep(99999)
    except KeyboardInterrupt:
        server.stop(0)

if __name__ == '__main__':
    serve()
