package unit3_multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public ServerMain() throws Exception {
		// Step 1: Create a server socket and a regular socket
		ServerSocket serverSocket = new ServerSocket(2020);
		System.out.println("Port 2020 is now open");
		
		while(true) {
			Socket regularSocket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(this, regularSocket);
			
			Thread thread = new Thread(serverThread);
			thread.start();
		}
	}
	
	private int clientCount = 0;
	public int getClientCount() {
		return ++clientCount;
	}
	
	public static void main(String[] args) {
		try {
			new ServerMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
