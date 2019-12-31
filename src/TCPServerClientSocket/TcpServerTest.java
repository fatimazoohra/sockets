package TCPServerClientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerTest {

	public static void main(String[] args) {
		System.out.println("serveur");
		ServerSocket serverSocket =null;
		int port =3016;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("serveur: ok sur le port="+port);	
		}catch(IOException ex){
			System.out.println("serveur:Impossible de creer le serveur avec le port="+port);
		}
		while(true) {
			Socket clientSocket = null;
			try {
				System.out.println("j'attend un client");
				clientSocket = serverSocket.accept();
				processClientRequest(clientSocket);
				//clientSocket.close();
				/*Avec les Thread */
				//clientSocket = serverSocket.accept();
				//int nbr++;
				//System.out.println("client :"+nbr);
				//(new Thread(new ClientWorker(clientSocket))).start();
			}catch(IOException ex){
				System.out.println("serveur:can not accept the client request, exit program");
			}
		
		}
	}

	public static void processClientRequest(Socket clientSocket){
		try {
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream() );
			InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String message = null;
			message = bufferedReader.readLine();
			printStream.println("le message recu du client" );
			System.out.println(message );
			printStream.println(message );
			Thread.sleep(1100);
			String messageSend = "serveur:"+message+"\n";
			printStream.println(messageSend );
			//printStream.println("yeeeeeeeeeeeeeeh" );
			printStream.close();
		
		}catch(IOException ex){
			System.out.println("Serveur : probable d'nvoi du message");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
		
		
		
/*		
		
try {
	processClientRequest1(clientSocket);
}catch(IOException ex){}catch(InterruptedException e) {
	e.printStackTrace();
}
		
		public static void processClientRequest(Socket clientSocket) throws IOExecption{
			try {
				Thread.sleep(1000);
				printStream printStream =new printStream (clientSocket);
			}
		}

	}

}

*/
