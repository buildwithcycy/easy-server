package cs327_lab4_udp_clientserver;
import java.net.*;
import java.io.*;

//UDP Server 
public class server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(1234);
		BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
		InetAddress ip = InetAddress.getByName("localhost");
		byte outData[] = new byte[1024];
		byte inData[] = new byte[1024];
		
		while(true) {
			DatagramPacket packet0 = new DatagramPacket(inData, inData.length);
			serverSocket.receive(packet0);
			String data = new String(packet0.getData());
			System.out.println(data);
			
			InetAddress ipAdd = packet0.getAddress();
			int port = packet0.getPort();
			String sendData = serverInput.readLine();
			//to send data 
			//outData = sendData.getBytes();
			outData = data.getBytes();
			DatagramPacket packet1 = new DatagramPacket(outData, outData.length, ipAdd, port);
			serverSocket.send(packet1);
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