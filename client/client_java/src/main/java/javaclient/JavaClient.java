package javaclient;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;


import com.firstproject.grpc.MessengerGrpc;
import com.firstproject.grpc.Message.ChannelInfo;
import com.firstproject.grpc.Message.ChannelList;
import com.firstproject.grpc.Message.ChannelRequest;
import com.firstproject.grpc.Message.ChannelType;
import com.firstproject.grpc.Message.Empty;
import com.firstproject.grpc.Message.MessageRequest;
import com.firstproject.grpc.Message.MessageResponse;


public class JavaClient {
	private final ManagedChannel channel;
    private final MessengerGrpc.MessengerBlockingStub blockingStub;
    private final MessengerGrpc.MessengerStub asyncStub;

    public JavaClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = MessengerGrpc.newBlockingStub(channel);
        this.asyncStub = MessengerGrpc.newStub(channel);
    }

    public void getChannels() {
        ChannelList response = blockingStub.getChannels(Empty.newBuilder().build());
        System.out.println("Bem vindo ao serviço de mensageria UFABC. Canais disponíveis: " + response.getChannelsList());
    }

    public void getChannelInfo(String channelName) {
        ChannelRequest request = ChannelRequest.newBuilder().setChannel(channelName).build();
        ChannelInfo response = blockingStub.getChannelInfo(request);
        System.out.println("Recebendo mensagens do canal " + response.getName() + " (" + response.getType()+ ")");
        //return response.getType();
    }
    
    public void receiveMessage(String channelName) {
    	ChannelRequest request = ChannelRequest.newBuilder().setChannel(channelName).build();
        ChannelInfo channelInfo = blockingStub.getChannelInfo(request);
    	//subscriber no canal tipo unary
        if (channelInfo.getType() == ChannelType.UNARY) {
        	//System.out.println("Ouvindo mensagens em unary :D ");
    		while (true) {
	            MessageResponse response = blockingStub.receiveMessage(request);
	            System.out.println("Mensagem recebida: " + response.getMessage());
    		}
    	}
        
        //subscriber no canal tipo streaming
    	if (channelInfo.getType() == ChannelType.STREAMING) {
    		//System.out.println("Ouvindo mensagens em streaming :D ");
    		//System.out.println("Recebendo mensagens no canal" + channelInfo.getName() );
    	    StreamObserver<MessageResponse> responseObserver = new StreamObserver<MessageResponse>() {
    	    	public void onNext(MessageResponse value) {
    	            System.out.println("Mensagem recebida: " + value.getMessage());
    	        }

    	        public void onError(Throwable t) {
    	            System.err.println("Error receiving message: " + t);
    	        }

    	        public void onCompleted() {
    	            System.out.println("Stream completed.");
    	        }
    	    };
    	    asyncStub.streamMessages(request, responseObserver);
    	    try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }

    public void postMessage(String channelName, String message) {
        MessageRequest request = MessageRequest.newBuilder()
                .setChannel(channelName)
                .setMessage(message)
                .build();
        @SuppressWarnings("unused")
		Empty response = blockingStub.postMessage(request);
        System.out.println("Message posted.");
    }

    public static void main(String[] args) {
    	JavaClient client = new JavaClient("localhost", 50000);

    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	String channel, role, message;
    	
        client.getChannels();
        System.out.println("Digite o nome do canal para se conectar: ");
        channel = scanner.nextLine();
        System.out.println("Selecione a função do cliente: (p para publisher, s para subscriber):  ");
        role = scanner.nextLine();
        
        if (role.equalsIgnoreCase("s"))
        {
        	client.getChannelInfo(channel);
        	client.receiveMessage(channel);
        }
        if (role.equalsIgnoreCase("p")) {
        	while(true) {
        	System.out.println("Digite a mensagem para postar: ");
            message = scanner.nextLine();
            client.postMessage(channel, message);
        	}
        	//System.out.println("publisher");
        }

        // Close the channel when done
        //client.channel.shutdown();
        
        
        
//        role = input("Selecione a função do cliente: (p para publisher, s para subscriber): ")
//                if role == 'p':
//                    while True:
//                        post_message(stub, selected_channel)
//                elif role == 's':
//                    listen_for_messages(stub, selected_channel, channel_type)

        
    }
	
	
	
}



