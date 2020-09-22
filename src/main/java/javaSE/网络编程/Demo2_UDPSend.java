package javaSE.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Demo2_UDPSend {
    public static void main(String args[]) throws IOException {
        /**
         * 1、创建socket对象
         * 2、创建packet对象
         * 3、用packet对象封装要发送的信息
         * 4、调用socket对象的方法发送信息
         * 5、关闭
          */

        System.out.println("发送............");

        DatagramSocket datagramSocket = new DatagramSocket(10001);

        //String message = "hello world!";
        //改进:有控制台输入并发送
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while((message = bufferedReader.readLine())!=null){
            byte[] buf=message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length, InetAddress.getByName("DESKTOP-984759Q"),63445);
            datagramSocket.send(datagramPacket);
            if(message.equals("over"))
                break;
        }

        datagramSocket.close();

    }
}
