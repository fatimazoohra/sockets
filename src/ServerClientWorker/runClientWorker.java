package ServerClientWorker;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class runClientWorker {
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket clientSocket = new Socket("localhost",25);
		Runnable clientWorker1 = new ClientWorker(clientSocket);
		new Thread(clientWorker1).run();
		Runnable clientWorker2 = new ClientWorker(clientSocket);
		new Thread(clientWorker2).run();
		
		//Runnable clientWorker2 = new ClientWorker(clientSocket);
		//new Thread(clientWorker2).start();
	}
}
