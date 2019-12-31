import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Inet {
	//petit exercice du cour
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Saisisssez une adresse(IPv4 ou nom de domaine");
			String entree =sc.nextLine();
			InetAddress Adresse = InetAddress.getByName(entree);
			System.out.println("IP : "+Adresse.getHostAddress());
			System.out.println("Nom : "+Adresse.getHostName());
		}catch( UnknownHostException e){
			e.printStackTrace();
		}

	}

}










/*public class Inet {
	
	public static void main(String[] args) {
		try {
			InetAddress adresse = InetAddress.getLocalHost();
			System.out.println("Nom : "+adresse.getHostName());
			System.out.println("Adresse: "+adresse.getHostAddress());
			System.out.println("Nom canonique : "+adresse.getCanonicalHostName());
			adresse = InetAddress.getByName("51.92.0.0"); 
			System.out.println("Nom : "+adresse.getHostName());
		}catch( UnknownHostException e){
			e.printStackTrace();
		}

	}

}*/

