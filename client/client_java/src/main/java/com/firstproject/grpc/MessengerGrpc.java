package com.firstproject.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: message.proto")
public final class MessengerGrpc {

  private MessengerGrpc() {}

  public static final String SERVICE_NAME = "messenger.Messenger";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.firstproject.grpc.Message.Empty,
      com.firstproject.grpc.Message.ChannelList> getGetChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannels",
      requestType = com.firstproject.grpc.Message.Empty.class,
      responseType = com.firstproject.grpc.Message.ChannelList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.firstproject.grpc.Message.Empty,
      com.firstproject.grpc.Message.ChannelList> getGetChannelsMethod() {
    io.grpc.MethodDescriptor<com.firstproject.grpc.Message.Empty, com.firstproject.grpc.Message.ChannelList> getGetChannelsMethod;
    if ((getGetChannelsMethod = MessengerGrpc.getGetChannelsMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getGetChannelsMethod = MessengerGrpc.getGetChannelsMethod) == null) {
          MessengerGrpc.getGetChannelsMethod = getGetChannelsMethod = 
              io.grpc.MethodDescriptor.<com.firstproject.grpc.Message.Empty, com.firstproject.grpc.Message.ChannelList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "messenger.Messenger", "GetChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.ChannelList.getDefaultInstance()))
                  .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("GetChannels"))
                  .build();
          }
        }
     }
     return getGetChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.ChannelInfo> getGetChannelInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannelInfo",
      requestType = com.firstproject.grpc.Message.ChannelRequest.class,
      responseType = com.firstproject.grpc.Message.ChannelInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.ChannelInfo> getGetChannelInfoMethod() {
    io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.ChannelInfo> getGetChannelInfoMethod;
    if ((getGetChannelInfoMethod = MessengerGrpc.getGetChannelInfoMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getGetChannelInfoMethod = MessengerGrpc.getGetChannelInfoMethod) == null) {
          MessengerGrpc.getGetChannelInfoMethod = getGetChannelInfoMethod = 
              io.grpc.MethodDescriptor.<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.ChannelInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "messenger.Messenger", "GetChannelInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.ChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.ChannelInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("GetChannelInfo"))
                  .build();
          }
        }
     }
     return getGetChannelInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.MessageResponse> getReceiveMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveMessage",
      requestType = com.firstproject.grpc.Message.ChannelRequest.class,
      responseType = com.firstproject.grpc.Message.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.MessageResponse> getReceiveMessageMethod() {
    io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.MessageResponse> getReceiveMessageMethod;
    if ((getReceiveMessageMethod = MessengerGrpc.getReceiveMessageMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getReceiveMessageMethod = MessengerGrpc.getReceiveMessageMethod) == null) {
          MessengerGrpc.getReceiveMessageMethod = getReceiveMessageMethod = 
              io.grpc.MethodDescriptor.<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "messenger.Messenger", "ReceiveMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.ChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("ReceiveMessage"))
                  .build();
          }
        }
     }
     return getReceiveMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.MessageResponse> getStreamMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamMessages",
      requestType = com.firstproject.grpc.Message.ChannelRequest.class,
      responseType = com.firstproject.grpc.Message.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest,
      com.firstproject.grpc.Message.MessageResponse> getStreamMessagesMethod() {
    io.grpc.MethodDescriptor<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.MessageResponse> getStreamMessagesMethod;
    if ((getStreamMessagesMethod = MessengerGrpc.getStreamMessagesMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getStreamMessagesMethod = MessengerGrpc.getStreamMessagesMethod) == null) {
          MessengerGrpc.getStreamMessagesMethod = getStreamMessagesMethod = 
              io.grpc.MethodDescriptor.<com.firstproject.grpc.Message.ChannelRequest, com.firstproject.grpc.Message.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "messenger.Messenger", "StreamMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.ChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("StreamMessages"))
                  .build();
          }
        }
     }
     return getStreamMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.firstproject.grpc.Message.MessageRequest,
      com.firstproject.grpc.Message.Empty> getPostMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PostMessage",
      requestType = com.firstproject.grpc.Message.MessageRequest.class,
      responseType = com.firstproject.grpc.Message.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.firstproject.grpc.Message.MessageRequest,
      com.firstproject.grpc.Message.Empty> getPostMessageMethod() {
    io.grpc.MethodDescriptor<com.firstproject.grpc.Message.MessageRequest, com.firstproject.grpc.Message.Empty> getPostMessageMethod;
    if ((getPostMessageMethod = MessengerGrpc.getPostMessageMethod) == null) {
      synchronized (MessengerGrpc.class) {
        if ((getPostMessageMethod = MessengerGrpc.getPostMessageMethod) == null) {
          MessengerGrpc.getPostMessageMethod = getPostMessageMethod = 
              io.grpc.MethodDescriptor.<com.firstproject.grpc.Message.MessageRequest, com.firstproject.grpc.Message.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "messenger.Messenger", "PostMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.firstproject.grpc.Message.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new MessengerMethodDescriptorSupplier("PostMessage"))
                  .build();
          }
        }
     }
     return getPostMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessengerStub newStub(io.grpc.Channel channel) {
    return new MessengerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessengerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessengerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessengerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessengerFutureStub(channel);
  }

  /**
   */
  public static abstract class MessengerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getChannels(com.firstproject.grpc.Message.Empty request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChannelsMethod(), responseObserver);
    }

    /**
     */
    public void getChannelInfo(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChannelInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void receiveMessage(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * Streaming
     * </pre>
     */
    public void streamMessages(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamMessagesMethod(), responseObserver);
    }

    /**
     */
    public void postMessage(com.firstproject.grpc.Message.MessageRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getPostMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetChannelsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.firstproject.grpc.Message.Empty,
                com.firstproject.grpc.Message.ChannelList>(
                  this, METHODID_GET_CHANNELS)))
          .addMethod(
            getGetChannelInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.firstproject.grpc.Message.ChannelRequest,
                com.firstproject.grpc.Message.ChannelInfo>(
                  this, METHODID_GET_CHANNEL_INFO)))
          .addMethod(
            getReceiveMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.firstproject.grpc.Message.ChannelRequest,
                com.firstproject.grpc.Message.MessageResponse>(
                  this, METHODID_RECEIVE_MESSAGE)))
          .addMethod(
            getStreamMessagesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.firstproject.grpc.Message.ChannelRequest,
                com.firstproject.grpc.Message.MessageResponse>(
                  this, METHODID_STREAM_MESSAGES)))
          .addMethod(
            getPostMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.firstproject.grpc.Message.MessageRequest,
                com.firstproject.grpc.Message.Empty>(
                  this, METHODID_POST_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessengerStub extends io.grpc.stub.AbstractStub<MessengerStub> {
    private MessengerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessengerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessengerStub(channel, callOptions);
    }

    /**
     */
    public void getChannels(com.firstproject.grpc.Message.Empty request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getChannelInfo(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChannelInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void receiveMessage(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReceiveMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Streaming
     * </pre>
     */
    public void streamMessages(com.firstproject.grpc.Message.ChannelRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postMessage(com.firstproject.grpc.Message.MessageRequest request,
        io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessengerBlockingStub extends io.grpc.stub.AbstractStub<MessengerBlockingStub> {
    private MessengerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessengerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessengerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.firstproject.grpc.Message.ChannelList getChannels(com.firstproject.grpc.Message.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetChannelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.firstproject.grpc.Message.ChannelInfo getChannelInfo(com.firstproject.grpc.Message.ChannelRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetChannelInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.firstproject.grpc.Message.MessageResponse receiveMessage(com.firstproject.grpc.Message.ChannelRequest request) {
      return blockingUnaryCall(
          getChannel(), getReceiveMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Streaming
     * </pre>
     */
    public java.util.Iterator<com.firstproject.grpc.Message.MessageResponse> streamMessages(
        com.firstproject.grpc.Message.ChannelRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.firstproject.grpc.Message.Empty postMessage(com.firstproject.grpc.Message.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getPostMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessengerFutureStub extends io.grpc.stub.AbstractStub<MessengerFutureStub> {
    private MessengerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessengerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessengerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.firstproject.grpc.Message.ChannelList> getChannels(
        com.firstproject.grpc.Message.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChannelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.firstproject.grpc.Message.ChannelInfo> getChannelInfo(
        com.firstproject.grpc.Message.ChannelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChannelInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.firstproject.grpc.Message.MessageResponse> receiveMessage(
        com.firstproject.grpc.Message.ChannelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReceiveMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.firstproject.grpc.Message.Empty> postMessage(
        com.firstproject.grpc.Message.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPostMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CHANNELS = 0;
  private static final int METHODID_GET_CHANNEL_INFO = 1;
  private static final int METHODID_RECEIVE_MESSAGE = 2;
  private static final int METHODID_STREAM_MESSAGES = 3;
  private static final int METHODID_POST_MESSAGE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessengerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessengerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CHANNELS:
          serviceImpl.getChannels((com.firstproject.grpc.Message.Empty) request,
              (io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelList>) responseObserver);
          break;
        case METHODID_GET_CHANNEL_INFO:
          serviceImpl.getChannelInfo((com.firstproject.grpc.Message.ChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.ChannelInfo>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGE:
          serviceImpl.receiveMessage((com.firstproject.grpc.Message.ChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse>) responseObserver);
          break;
        case METHODID_STREAM_MESSAGES:
          serviceImpl.streamMessages((com.firstproject.grpc.Message.ChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.MessageResponse>) responseObserver);
          break;
        case METHODID_POST_MESSAGE:
          serviceImpl.postMessage((com.firstproject.grpc.Message.MessageRequest) request,
              (io.grpc.stub.StreamObserver<com.firstproject.grpc.Message.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessengerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.firstproject.grpc.Message.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Messenger");
    }
  }

  private static final class MessengerFileDescriptorSupplier
      extends MessengerBaseDescriptorSupplier {
    MessengerFileDescriptorSupplier() {}
  }

  private static final class MessengerMethodDescriptorSupplier
      extends MessengerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessengerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessengerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessengerFileDescriptorSupplier())
              .addMethod(getGetChannelsMethod())
              .addMethod(getGetChannelInfoMethod())
              .addMethod(getReceiveMessageMethod())
              .addMethod(getStreamMessagesMethod())
              .addMethod(getPostMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
