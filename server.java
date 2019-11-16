package cs327_lab4_udp_clientserver;
import java.net.*;
import java.io.*;
//UDP Server

public class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(1234);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            InetAddress ip = InetAddress.getByName("localhost");
            byte outData[] = new byte[1024];
            byte inData[] = new byte[1024];

            while (true) {
                DatagramPacket packet0 = new DatagramPacket(inData, inData.length);
                serverSocket.receive(packet0);
                String data = new String(packet0.getData());
                System.out.println(data);

                InetAddress ipAdd = packet0.getAddress();
                int port = packet0.getPort();
                String sendData = serverInput.readLine();
                //to send data
                outData = sendData.getBytes();
                DatagramPacket packet1 = new DatagramPacket(outData, outData.length, ipAdd, port);
                serverSocket.send(packet1);
            }
        }//end of try
        catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        }//end of catch block
        catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        }//end of catch block

        finally{
            if(serverSocket != null){
                serverSocket.close();
            }
        }//end of finally block
    }
}//end of server class