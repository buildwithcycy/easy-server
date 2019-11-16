package cs327_lab4_udp_clientserver;
import java.net.*;
import java.io.*;
//UDP client 

public class client {
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("localhost");
		byte outData[] = new byte[1024];
		String data = input.readLine();
		outData = data.getBytes();
		DatagramPacket packet = new DatagramPacket(outData, outData.length, ip, 1234);
		clientSocket.send(packet);
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