package cs327_lab4_udp_clientserver;
import java.net.*;
import java.io.*;

//UDP Server 
public class server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(1234);
		byte inData[] = new byte[1024];
		while(true) {
			DatagramPacket packet0 = new DatagramPacket(inData, inData.length);
			serverSocket.receive(packet0);
			String data = new String(packet0.getData());
			System.out.println(data);
		}
		/*
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			while(true) {
				DatagramPacket request = new DatagramPacket(buffer,  buffer.length);
				aSocket.receive(request);
				DatagramPacket reply = new DatagramPacket(request.getData(), 
						request.getLength(), request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
		}catch (SocketException e) {System.out.println("Socket: " + e.getMessage());
	}catch (IOException e) { System.out.println("IO: " + e.getMessage()); 
	}finally { if(aSocket != null) aSocket.close(); }
		
		*/
}
}