package javaSE.网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo9_TCPServer_File {
    public static void main(String args[]) throws IOException{
        ServerSocket server =new ServerSocket(10001);

        Socket client = server.accept();
        String ip = client.getInetAddress().getHostAddress();
        System.out.println(ip+".............successfully connect");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        File file = new File("G:\\Java学习\\JavaSE基础视频26\\javaSE.网络编程\\练习\\demo9.doc");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String line = null;
        while((line= in.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

        out.println("上传完毕！");

        bufferedWriter.close();
        client.close();
        server.close();
    }
}
