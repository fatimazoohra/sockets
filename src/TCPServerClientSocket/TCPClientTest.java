package TCPServerClientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) throws IOException {
		System.out.println("client");
		Socket clientSocket =null;
		String serverHostName = "localhost";
		int port = 3016;
		for(int i=0;i<3;i++) {
			try {
				clientSocket = new Socket(serverHostName,port);
				//clientSocket = new Socket("192.168.1.10",1234);
				System.out.println("connected to the server");
			}catch(IOException e) {
				System.out.println("client: impossible d'ouvrir la socket");
			}
			long t = System.currentTimeMillis();
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
			InputStreamReader inputStream= new InputStreamReader(clientSocket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String message = "bonjour \n\n";
			printStream.print(message);
			printStream.flush();
			message = bufferedReader.readLine();
			System.out.println("serveur rep:"+message);
			message = bufferedReader.readLine();
			System.out.println("serveur rep:"+message);
			message = bufferedReader.readLine();
			System.out.println("serveur rep:"+message+(System.currentTimeMillis()-t));
			
			/*
			 try {
192.168.1.10
			//soc = new Socket("127.0.0.1",i);
			//InetAddress Adresse = InetAddress.getByName("192.168.43.73");
			clientSoc = new Socket("192.168.1.3",1234);
			System.out.println("en ecoute");
			String message = "b16 \n\n";
			PrintStream printStream = new PrintStream(clientSoc.getOutputStream());
			printStream.print(message);
			//BufferedOutputStream bos= new BufferedOutputStream(clientSoc.getOutputStream());
			//bos.write(message.getBytes());
			//bos.flush();
			clientSoc.close();
			System.out.println("message envoyé");
		}catch(IOException e) {
			System.out.println("Imposssiblle s'ouvrir le socket du serveur");
		}
		 */
			
		}
		

	}

}
