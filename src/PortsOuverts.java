import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortsOuverts {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("liste des ports ouverts: ");
		Socket soc = null;
			//InetAddress Adresse = InetAddress.getByName("localhost");
			for(int i=1000; i <= 2000; i++) {
				try {
					soc = new Socket("127.0.0.1",i);
					System.out.println(i);
				}catch(UnknownHostException e) {e.printStackTrace();}
				catch(IOException e) {}	
				finally {
					if(soc != null) {
						try {
							soc.close();
						}catch(IOException e) {
							e.printStackTrace();
							soc = null;
						}	
					}
				}
			}
			//System.out.println("all : "+InetAddress.getAllByName("localhost"));
	
	}

}
