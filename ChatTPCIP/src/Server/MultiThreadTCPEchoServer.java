package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiThreadTCPEchoServer {
	public final static int DEFAULT_PORT = 5000;

	public static void main(String[] args) {
		try(ServerSocket servSocket = new ServerSocket(DEFAULT_PORT)){
			while(true){
				Runnable t = new TCPEchoThread(servSocket.accept());
				System.out.println("Accepted client:" +  servSocket.getInetAddress().getHostAddress());
				new Thread(t).start();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
