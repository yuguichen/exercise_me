package javaSE.网络编程;

import java.io.*;
import java.net.Socket;

public class Demo8_TCPClient_File {
    public static void main(String args[]) throws IOException{

        Socket client = new Socket("192.168.1.129",10001);

        File file = new File("F:\\老师课件\\unit 6\\Lif.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

        String line= null;
        while((line=bufferedReader.readLine())!=null){
            out.println(line);

        }

        client.shutdownOutput();

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str=in.readLine();
        System.out.println(str);

        bufferedReader.close();
        client.close();
    }
}
