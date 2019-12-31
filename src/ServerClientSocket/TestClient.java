package ServerClientSocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) {
		System.out.println("============Client=============");
		Socket clientSoc = null;
		try {

			//soc = new Socket("127.0.0.1",i);
			//InetAddress Adresse = InetAddress.getByName("192.168.43.73");
			clientSoc = new Socket("localhost",1234);
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
	}

}
