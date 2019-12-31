import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Socket;

public class TestSocket {

	public static void main(String[] args) {
		try {
		Socket sc = new Socket(InetAddress.getByName("www.github.com"),80);
		System.out.println(sc);
		}catch(UnknownHostException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}	
	}

}

