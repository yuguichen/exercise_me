package javaSE.网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class Demo3_UDPReceive {
    public static void main(String args[]) throws IOException {
        /**
         * 1、创建socket对象
         * 2、创建packet对象
         * 3、调用socket对象的方法接受信息
         * 4、用packet对象解封收到的信息
         *
         */

        System.out.println("接收............");

        //接收时要指明端口号
        DatagramSocket datagramSocket = new DatagramSocket(63445);
        Boolean flag = true;
        while(flag){
            byte[] buf=new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);

            datagramSocket.receive(datagramPacket);//阻塞式语句

            int port = datagramPacket.getPort();
            String ip = datagramPacket.getAddress().getHostAddress();
            String  data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println(ip+"::"+port+"::"+data);
            flag=!data.equals("over");
        }
        datagramSocket.close();
    }
}
