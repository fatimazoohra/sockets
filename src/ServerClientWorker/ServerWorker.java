/*Avec les Thread */
package ServerClientWorker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerWorker implements Runnable{

    protected int  serverPort   = 3000 ;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    private static PrintStream printStream = null;
    private static InputStreamReader inputStream = null;
    private static BufferedReader bufferedReader = null;
	//private static /*final*/ ArrayList<String> tabMessages = null;
	private static /*final*/ ArrayList<Socket> tabSockets = new ArrayList<Socket>();
	public static ArrayList<Socket> getTabSockets(){
		return tabSockets;
	}/*
	public static ArrayList<String> getTabMessages(){
		return tabMessages;
	}*/
    public ServerWorker(int port) {
    	this.serverPort = port;
    }
	public synchronized void run() {
		System.out.println("-------------------------it's the SERVER side ------------------------");
		ServerSocket serverSocket = null;
		try {
            this.serverSocket = new ServerSocket(this.serverPort);
        }catch(IOException ex){
			System.out.println("server:can not open the port: "+serverPort);
		} 
		int i = 0;
		while(true) {
			i++;
			Socket clientSocket = null;
			try {
				System.out.println("\n i'm waiting for a client");	
				clientSocket = this.serverSocket.accept();
				(new Thread(new ClientWorker(clientSocket))).start();
				Thread.sleep(1100);
				processClientRequest(clientSocket);
				
			}catch(IOException | InterruptedException ex){
				System.out.println("\n server can not accept the client request, exit program");
			}
		}
	}
	public static synchronized void processClientRequest(Socket clientSocket) throws InterruptedException{
		/*try {
			(new Thread(new ClientWorker(clientSocket))).start();
			//Thread.sleep(1100);
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream() );
			InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStream);
			String message = null;
			message = bufferedReader.readLine();
			printStream.println("i received this message \n\n");
			//Thread.sleep(1100);
			printStream.flush();
			//printStream.close();//: " +message+"
		
		}catch(IOException ex){
			System.out.println("i can not resend the message");
		}finally{
			if(!clientSocket.isClosed()){
				try {
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/try {
			tabSockets.add(clientSocket);
			System.out.print(tabSockets);
			for(int i=0 ;i<tabSockets.size(); i++) {
				printStream = new PrintStream(tabSockets.get(i).getOutputStream() );
				inputStream = new InputStreamReader(tabSockets.get(i).getInputStream());
				bufferedReader = new BufferedReader(inputStream);
				String message = null;
				message = bufferedReader.readLine();
				System.out.println("Server => i got this message from the client: "+message);
				//tabMessages.add(message);
				Thread.sleep(1000);
				String messageSend = "server response: "+message+"\n\n";
				printStream.print(messageSend);
				printStream.close();
				bufferedReader.close();
				tabSockets.get(i).close();
			}
		}catch(IOException ex){
			System.out.println("Serveur : i didn't sent the message");
		}
		
	}	
	
	/*public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }*/
	

	
	
	
}
