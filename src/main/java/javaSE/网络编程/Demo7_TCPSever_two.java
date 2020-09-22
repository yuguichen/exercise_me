package javaSE.网络编程;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Demo7_TCPSever_two {
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(10002);

        Socket client = server.accept();
        String ip = client.getInetAddress().getHostAddress();
        System.out.println("主机"+ip+"connect............");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()) );

        //OutputStream out = client.getOutputStream();

        // 构造参数是若有true
        //      PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        // 则自动刷新缓冲区
        //若没有true，则需调用flush函数刷新
        PrintWriter out = new PrintWriter(client.getOutputStream());

        String text;
        while((text =in.readLine())!=null ){
            System.out.println(text);
            if(text.equals("over"))
                break;

            out.println(text.toUpperCase());
            out.flush();
        }

        client.close();
        server.close();

    }
}
