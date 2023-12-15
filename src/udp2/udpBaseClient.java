package udp2;

//Java program to illustrate Client side
//Implementation using DatagramSocket 
import java.io.IOException;
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class udpBaseClient
{ 
	
	
	public static void main(String args[]) throws IOException
	{ 
		// Step 1: the socket object for 
		// carrying the data. 
		Scanner sc1 = new Scanner(System.in); //Creating an object of Scanner class to read user
		System.out.println("donner votre nom");
		DatagramSocket ds1 = new DatagramSocket(); 
		InetAddress ip1 = InetAddress.getLocalHost();  //w  baad nhot addresse ip walla server ip
		byte nom[]=null;
		String inp1 = sc1.nextLine(); //t7ather msg elli bech tebaatho
		nom=inp1.getBytes();
		DatagramPacket DpSend1 = new DatagramPacket(nom, nom.length, ip1, 8888);
		ds1.send(DpSend1);

		
		Scanner sc = new Scanner(System.in); //Creating an object of Scanner class to read user
		System.out.println("écrire un message");
		
		// Step 1: the socket object for 
		// carrying the data. 
		DatagramSocket ds = new DatagramSocket(); 

		InetAddress ip = InetAddress.getLocalHost(); //bech tekhou l'adresse mtaa  client 
		byte buf[] = null; //zone eli stocké fiha datagramme nenisializiwha ala 0
		 
		
		// loop while user not enters "bye" 
		while (true) 
		{ 
			
			
			String inp = sc.nextLine(); 

			// convert the String input into the byte array. 
			buf = inp.getBytes(); //bytes mtaa data nhetouhom fi buf
			

			// Step 2 : Create the datagramPacket for sending 
			// the data. 
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
			//buf howa databytes length mtaa databytes adresse ip mtaa server (destination adresse) w 1234 howa port
			
            //construit un objet pour envoyer un datagramme 
			//buffer correspond a la zone ou est stocké le datagramme a envoyer 
			//length : taille du datagramme a envoyer 
			//l'adresse de la machine a qui envoyer le datagramme
			//port sur quel port UDP

			// Step 3 : invoke the send call to actually send 
			// the data. 
			ds.send(DpSend); //tawa tebaathha packet baad ma snaatha

			// break the loop if user enters "bye" 
			if (inp.equals("bye")) //ken kteb bye okhrej
				break; 
		} 
		ds1.close();
		sc1.close();
		ds.close(); //nsakrou packet 
		sc.close();
		
		
		
	} 
} 
