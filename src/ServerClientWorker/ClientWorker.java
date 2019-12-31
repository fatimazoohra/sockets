package ServerClientWorker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientWorker implements Runnable{
	Socket clientSocket;
	ClientWorker(Socket s) throws UnknownHostException, IOException {
		clientSocket=s;
	}
	
	public /*synchronized*/ void run() {
		System.out.println("-------------------------it's the CLIENT side ------------------------");
		//for(int i=0;i<2;i++) {
			try {
				clientSocket = new Socket("localhost",3000);
				System.out.println("connected to the server");
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				//Thread.sleep(1000);
				long t = System.currentTimeMillis();
				PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
				InputStreamReader inputStream= new InputStreamReader(clientSocket.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStream);
				String message = "it's the client message \n\n";
				String serverMessage ="";
				printStream.print(message);
				printStream.flush();
				System.out.print(message);
				Thread.sleep(10);
				
					serverMessage = bufferedReader.readLine();
					System.out.print("\n i got this message from the server"+serverMessage+" in "+(System.currentTimeMillis()-t)+"\n");
				
				
			
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		//}
	}


}
