package cs327_lab4_udp_clientserver;
import java.net.*;
import java.io.*;
//UDP client

public class client {
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

        finally{
            if(clientSocket != null){
                clientSocket.close();
            }
        }//end of finally block
    }

}//end of client Class
