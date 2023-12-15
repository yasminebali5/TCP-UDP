package udp2;

//Java program to illustrate Server side
//Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class udpBaseServer
{
	public static void main(String[] args) throws IOException
	{
		
		
		DatagramSocket ds1 = new DatagramSocket(8888);
		byte[] receive1 = new byte[65535];
		DatagramPacket DpReceive1 = null;
		
		
		
		
		
		// Step 1 : Create a socket to listen at port 1234
		DatagramSocket ds = new DatagramSocket(1234);
		
		//create a buffer to read the receive data 
		byte[] receive = new byte[65535];

		DatagramPacket DpReceive = null;
		
		while (true)
		{

			DpReceive1 = new DatagramPacket(receive1, receive1.length);
			ds1.receive(DpReceive1);
			
			// Step 2 : create a DatgramPacket to receive the data.
			DpReceive = new DatagramPacket(receive, receive.length);

			// Step 3 : receive the data in byte buffer.
			ds.receive(DpReceive);
			System.out.println(data(receive1)+" is connecting ");
			System.out.println(data(receive1)+" says "+ data(receive));
			
			// Exit the server if the client sends "bye"
			if (data(receive).toString().equals("bye"))
			{
				System.out.println(data(receive1)+" sent bye.....EXITING");
				break;
			}

			// Clear the buffer after every message.
			
			
			receive = new byte[65535];
			receive1 = new byte[65535];
		
		}
		
		
		
	}

	// A utility method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a) //maho ahna snaana liste bytes buffer bech nhawlouh el data nestaamlou methode hethi
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
