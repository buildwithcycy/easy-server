package cs327_lab4_udp_clientserver;
import java.net.*;
import java.util.*;
import java.io.*;
//UDP client 

public class client {
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an ip address");
		String ipInput = in.next();
		System.out.println("Please enter an port address");
		int portInput = in.nextInt();
	
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a Message to Send to Server?");
		DatagramSocket clientSocket = new DatagramSocket();
		//InetAddress ip = InetAddress.getByName("localhost");
		InetAddress ip = InetAddress.getByName(ipInput);
		byte inData[] = new byte[1024];
		byte outData[] = new byte[1024];
		String data = input.readLine();
		String message = new String("");
		
		

		
		//port 1234
				
		outData = data.getBytes();
		DatagramPacket packet = new DatagramPacket(outData, outData.length, ip, portInput);
		clientSocket.send(packet);
		DatagramPacket packet2 = new DatagramPacket(inData, inData.length, ip, portInput);
		clientSocket.receive(packet2);
		String receiveData =new String(packet2.getData());
		System.out.println(receiveData);
		clientSocket.close();
	}
		/*
		 * 		DatagramSocket aSocket = null;

		try { 
			aSocket = new DatagramSocket();
			byte[] m = args[0].getBytes();
			InetAddress aHost = InetAddress.getByName(args[1]);
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));
			
		}catch (SocketException e) { System.out.println("Socket: " + e.getMessage());
	} catch(IOException e) { System.out.println("IO: " + e.getMessage());
	} finally { if(aSocket != null) aSocket.close();}
}
	*/
}