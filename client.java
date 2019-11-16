package cs327_lab4_udp_clientserver;
import java.net.*;
import java.util.*;
import java.io.*;
//UDP client

public class client {
<<<<<<< HEAD
    public static void main(String args[]) throws Exception {
        // args give message contents and server hostname
        DatagramSocket clientSocket  = null;
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            clientSocket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");
            byte inData[] = new byte[1024];
            byte outData[] = new byte[1024];
            String data = input.readLine();
            outData = data.getBytes();
            DatagramPacket packet = new DatagramPacket(outData, outData.length, ip, 1234);
            clientSocket.send(packet);
            DatagramPacket packet2 = new DatagramPacket(inData, inData.length, ip, 1234);
            clientSocket.receive(packet2);
            String receiveData = new String(packet2.getData());
            System.out.println(receiveData);
        }
        catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        }//end of catch block
        catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        }//end of catch block
=======
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
>>>>>>> e86a168d32e15735fe9c6b494ef33523964a6c64

        finally{
            if(clientSocket != null){
                clientSocket.close();
            }
        }//end of finally block
    }

}//end of client Class
