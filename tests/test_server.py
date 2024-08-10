import unittest
import grpc
from grpc_testing import server_from_dictionary, strict_real_time
from server import message_pb2, message_pb2_grpc
from server.server_python import MessengerServicer


class MessengerServicerTest(unittest.TestCase):
    def setUp(self):
        # Criação do servicer e do servidor de teste
        servicers = {
            message_pb2.DESCRIPTOR.services_by_name['Messenger']: MessengerServicer()
        }
        self.test_server = server_from_dictionary(servicers, strict_real_time())
        self.test_server.start()

        # Criar um canal para se conectar ao servidor de teste
        self.channel = grpc.insecure_channel(self.test_server.target())
        self.stub = message_pb2_grpc.MessengerStub(self.channel)

    def tearDown(self):
        self.test_server.stop(0)

    def test_create_channel(self):
        # Testar a criação de um canal
        response = self.stub.GetChannels(message_pb2.Empty())
        self.assertEqual(len(response.channels), 0)

        # Criar um canal UNARY
        self.stub.PostMessage(message_pb2.MessageRequest(channel="canal_unary", message="Hello"))
        response = self.stub.GetChannels(message_pb2.Empty())
        self.assertEqual(len(response.channels), 1)
        self.assertEqual(response.channels[0], "canal_unary")

    def test_post_and_receive_message_unary(self):
        # Criar um canal UNARY e enviar mensagem
        self.stub.PostMessage(message_pb2.MessageRequest(channel="canal_unary", message="Mensagem 1"))
        response = self.stub.ReceiveMessage(message_pb2.ChannelRequest(channel="canal_unary"))
        self.assertEqual(response.message, "Mensagem 1")

    def test_post_and_receive_message_streaming(self):
        # Criar um canal STREAMING
        self.stub.PostMessage(message_pb2.MessageRequest(channel="canal_streaming", message="Mensagem Streaming"))
        response = self.stub.StreamMessages(message_pb2.ChannelRequest(channel="canal_streaming"))

        # Receber a primeira mensagem
        message_response = next(response)
        self.assertEqual(message_response.message, "Mensagem Streaming")

    def test_delete_channel(self):
        # Criar um canal e verificar que ele existe
        self.stub.PostMessage(message_pb2.MessageRequest(channel="canal_para_deletar", message=""))
        response = self.stub.GetChannels(message_pb2.Empty())
        self.assertIn("canal_para_deletar", response.channels)

        # Deletar o canal e verificar que ele foi removido
        self.stub.PostMessage(message_pb2.MessageRequest(channel="canal_para_deletar", message=""))
        response = self.stub.GetChannels(message_pb2.Empty())
        self.assertNotIn("canal_para_deletar", response.channels)


if __name__ == '__main__':
    unittest.main()