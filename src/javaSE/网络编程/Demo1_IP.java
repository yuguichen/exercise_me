package javaSE.网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1_IP {
    public static void main(String args[]) throws UnknownHostException {

        //创建IP对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("HostAddress:"+inetAddress.getHostAddress());
        System.out.println("HostName:"+inetAddress.getHostName());
        System.out.println("Address:"+inetAddress.getAddress());
        System.out.println("CanonicalHostName:"+inetAddress.getCanonicalHostName());

        inetAddress = InetAddress.getByName("闪电");
        System.out.println("闪电：HostAddress:"+inetAddress.getHostAddress());
        System.out.println("闪电：HostName:"+inetAddress.getHostName());

    }
}
