package javaSE.网络编程;

import java.io.*;
import java.net.Socket;

public class Demo6_TCPClient_two {
    public static void main(String args[]) throws IOException{
        /**
         * 需求：实现TCP服务端与客户端交互
         * 客户端向服务端发送小写字母，服务端接收后将小写字母转换成大写并发送回客户端
         *
         * * TCP客户端
         *    1、创建TCP客户端socket服务，
         *        明确要连接的目的地：IP+端口号
         *    2、建立socket输入输出 流；
         *    3、使用输出流，将数据写出；
         *    4、关闭资源。
         */

        Socket client = new Socket("192.168.1.129",10001);

        //获取键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

       // OutputStream  out = client.getOutputStream();
        PrintWriter out = new PrintWriter(client.getOutputStream(),true) ;

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        byte[] buf = new byte[1024];

        String line;
        while ((line=bufr.readLine())!=null){
            if(line.equals("over"))
                break;

            out.println(line);

             String upperStr =in.readLine();

            System.out.println( upperStr);
        }

        client.close();




    }
}
