package javaSE.网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 * 1、创建TCP服务端serveSocket服务，
 *        明确端口号让客户端链接
 * 2、调用server对象的方法获取连接服务器的客户端对象
 * 3、建立socket  InputStream流；
 * 4、使用输入流，将数据读出；
 * 5、关闭资源。
 *     一般不关闭服务器
 */

public class Demo5_TCPSever {
    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(10001);

        Socket socket=server.accept();
        String ip = socket.getInetAddress().getHostAddress();

        InputStream in = socket.getInputStream();
        byte[] buf=new byte[1024];
        int length = in.read(buf);
        String text = new String(buf,0,length);
        System.out.println(ip+":"+text);

        OutputStream out = socket.getOutputStream();
        out.write("你好！！！".getBytes());

        socket.close();
        server.close();
    }
}
