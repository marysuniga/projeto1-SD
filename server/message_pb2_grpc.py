# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc
import warnings

from server import message_pb2 as message__pb2

GRPC_GENERATED_VERSION = '1.65.1'
GRPC_VERSION = grpc.__version__
EXPECTED_ERROR_RELEASE = '1.66.0'
SCHEDULED_RELEASE_DATE = 'August 6, 2024'
_version_not_supported = False

try:
    from grpc._utilities import first_version_is_lower
    _version_not_supported = first_version_is_lower(GRPC_VERSION, GRPC_GENERATED_VERSION)
except ImportError:
    _version_not_supported = True

if _version_not_supported:
    warnings.warn(
        f'The grpc package installed is at version {GRPC_VERSION},'
        + f' but the generated code in message_pb2_grpc.py depends on'
        + f' grpcio>={GRPC_GENERATED_VERSION}.'
        + f' Please upgrade your grpc module to grpcio>={GRPC_GENERATED_VERSION}'
        + f' or downgrade your generated code using grpcio-tools<={GRPC_VERSION}.'
        + f' This warning will become an error in {EXPECTED_ERROR_RELEASE},'
        + f' scheduled for release on {SCHEDULED_RELEASE_DATE}.',
        RuntimeWarning
    )


class MessengerStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.GetChannels = channel.unary_unary(
                '/messenger.Messenger/GetChannels',
                request_serializer=message__pb2.Empty.SerializeToString,
                response_deserializer=message__pb2.ChannelList.FromString,
                _registered_method=True)
        self.GetChannelInfo = channel.unary_unary(
                '/messenger.Messenger/GetChannelInfo',
                request_serializer=message__pb2.ChannelRequest.SerializeToString,
                response_deserializer=message__pb2.ChannelInfo.FromString,
                _registered_method=True)
        self.ReceiveMessage = channel.unary_unary(
                '/messenger.Messenger/ReceiveMessage',
                request_serializer=message__pb2.ChannelRequest.SerializeToString,
                response_deserializer=message__pb2.MessageResponse.FromString,
                _registered_method=True)
        self.StreamMessages = channel.unary_stream(
                '/messenger.Messenger/StreamMessages',
                request_serializer=message__pb2.ChannelRequest.SerializeToString,
                response_deserializer=message__pb2.MessageResponse.FromString,
                _registered_method=True)
        self.PostMessage = channel.unary_unary(
                '/messenger.Messenger/PostMessage',
                request_serializer=message__pb2.MessageRequest.SerializeToString,
                response_deserializer=message__pb2.Empty.FromString,
                _registered_method=True)


class MessengerServicer(object):
    """Missing associated documentation comment in .proto file."""

    def GetChannels(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def GetChannelInfo(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def ReceiveMessage(self, request, context):
        """Unary
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def StreamMessages(self, request, context):
        """Streaming
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def PostMessage(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_MessengerServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'GetChannels': grpc.unary_unary_rpc_method_handler(
                    servicer.GetChannels,
                    request_deserializer=message__pb2.Empty.FromString,
                    response_serializer=message__pb2.ChannelList.SerializeToString,
            ),
            'GetChannelInfo': grpc.unary_unary_rpc_method_handler(
                    servicer.GetChannelInfo,
                    request_deserializer=message__pb2.ChannelRequest.FromString,
                    response_serializer=message__pb2.ChannelInfo.SerializeToString,
            ),
            'ReceiveMessage': grpc.unary_unary_rpc_method_handler(
                    servicer.ReceiveMessage,
                    request_deserializer=message__pb2.ChannelRequest.FromString,
                    response_serializer=message__pb2.MessageResponse.SerializeToString,
            ),
            'StreamMessages': grpc.unary_stream_rpc_method_handler(
                    servicer.StreamMessages,
                    request_deserializer=message__pb2.ChannelRequest.FromString,
                    response_serializer=message__pb2.MessageResponse.SerializeToString,
            ),
            'PostMessage': grpc.unary_unary_rpc_method_handler(
                    servicer.PostMessage,
                    request_deserializer=message__pb2.MessageRequest.FromString,
                    response_serializer=message__pb2.Empty.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'messenger.Messenger', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))
    server.add_registered_method_handlers('messenger.Messenger', rpc_method_handlers)


 # This class is part of an EXPERIMENTAL API.
class Messenger(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def GetChannels(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/messenger.Messenger/GetChannels',
            message__pb2.Empty.SerializeToString,
            message__pb2.ChannelList.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def GetChannelInfo(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/messenger.Messenger/GetChannelInfo',
            message__pb2.ChannelRequest.SerializeToString,
            message__pb2.ChannelInfo.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def ReceiveMessage(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/messenger.Messenger/ReceiveMessage',
            message__pb2.ChannelRequest.SerializeToString,
            message__pb2.MessageResponse.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def StreamMessages(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(
            request,
            target,
            '/messenger.Messenger/StreamMessages',
            message__pb2.ChannelRequest.SerializeToString,
            message__pb2.MessageResponse.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def PostMessage(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/messenger.Messenger/PostMessage',
            message__pb2.MessageRequest.SerializeToString,
            message__pb2.Empty.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)
