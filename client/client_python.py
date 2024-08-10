import grpc
from server import message_pb2
from server import message_pb2_grpc
import time
import threading
import os

def list_channels(stub):
    response = stub.GetChannels(message_pb2.Empty())
    return response.channels

def get_channel_info(stub, channel):
    request = message_pb2.ChannelRequest(channel=channel)
    return stub.GetChannelInfo(request)

def listen_for_messages(stub, channel, channel_type, timeout=15):
    last_received_time = time.time()

    def timeout_check():
        while True:
            if time.time() - last_received_time > timeout:
                print(f"Não foram recebidas mensagens por {timeout} segundos. Encerrando o assinante.")
                break
            time.sleep(1)
        os._exit(0)
    timeout_thread = threading.Thread(target=timeout_check)
    timeout_thread.daemon = True
    timeout_thread.start()

    if channel_type == message_pb2.UNARY:
        print(f"Ouvindo mensagens em {channel} (Unary RPC)...")
        while True:
            request = message_pb2.ChannelRequest(channel=channel)
            try:
                response = stub.ReceiveMessage(request)
                print(f"Mensagem recebida: {response.message}")
                last_received_time = time.time()
                time.sleep(1)
            except grpc.RpcError as e:
                print(f"Erro ao receber mensagens: {e}")
                time.sleep(1)  
    elif channel_type == message_pb2.STREAMING:
        print(f"Ouvindo mensagens em {channel} (Streaming RPC)...")
        request = message_pb2.ChannelRequest(channel=channel)
        try:
            for response in stub.StreamMessages(request):
                print(f"Mensagem recebida: {response.message}")
                last_received_time = time.time()
        except grpc.RpcError as e:
            print(f"Erro ao receber mensagens: {e}")

def post_message(stub, channel):
    message = input("Digite a mensagem para postar: ")
    request = message_pb2.MessageRequest(channel=channel, message=message)
    stub.PostMessage(request)
    print("Mensagem postada.")

def run():
    with grpc.insecure_channel('localhost:50000') as channel:
        stub = message_pb2_grpc.MessengerStub(channel)
        channels = list_channels(stub)
        print(f"Canais disponíveis: {channels}")
        selected_channel = input("Digite o nome do canal para se conectar: ")

        channel_info = get_channel_info(stub, selected_channel)
        channel_type = channel_info.type

        role = input("Selecione a função do cliente: (p para publisher, s para subscriber): ")
        if role == 'p':
            while True:
                post_message(stub, selected_channel)
        elif role == 's':
            listen_for_messages(stub, selected_channel, channel_type)

if __name__ == '__main__':
    run()
