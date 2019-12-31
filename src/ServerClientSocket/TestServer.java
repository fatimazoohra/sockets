package ServerClientSocket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) {
		System.out.println("===========Server=============");
		Socket clientSocket = null;
		ServerSocket serveurSoc = null;
		while(true) {
			try {
				serveurSoc = new ServerSocket(1234);
				clientSocket = serveurSoc.accept();
				System.out.println("un client s'est connecté");	
				
				BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
				StringBuilder sb = new StringBuilder();
				int n;
				while((n = bis.read()) != -1) {
					sb.append((char)n);
				}
				System.out.println(sb);
				clientSocket.close();
				serveurSoc.close();
				
			}catch(IOException e) {
				e.printStackTrace();
				return ;
			}
		}

	}

}
