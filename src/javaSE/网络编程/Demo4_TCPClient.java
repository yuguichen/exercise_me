package javaSE.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP客户端
 * 1、创建TCP客户端socket服务，
 *        明确要连接的目的地：IP+端口号
 * 2、建立socket输入输出 流；
 * 3、使用输出流，将数据写出；
 * 4、关闭资源。
 */
public class Demo4_TCPClient {
    public static void main(String args[]) throws IOException {
        // 1、创建TCP客户端socket服务
        Socket socket = new Socket("192.168.1.129",10001);
        // 2、建立socket流；
        OutputStream out = socket.getOutputStream();
        // 3、使用输出流，将数据写出；
        out.write("hello TCP_world".getBytes());

        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length;
        String str;
        while ((length=in.read(buf))!=-1)
        {
            str=new String(buf,0,buf.length);
            System.out.println(str);
        }
        socket.close();


    }
}
