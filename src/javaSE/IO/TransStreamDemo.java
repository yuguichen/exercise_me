package javaSE.IO;

import java.io.*;

public class TransStreamDemo {
    public static void main(String args[]) throws IOException{
        //InputStream in = System.in;
        //将字节转换成字符的桥梁
        //InputStreamReader isr =new InputStreamReader(in);
        //BufferedReader br = new BufferedReader(isr);
        BufferedReader buffr = new BufferedReader(new InputStreamReader(System.in));


        //将字符流转换成字节流输出
        //OutputStream out = System.out;
        //OutputStreamWriter OWS = new OutputStreamWriter(out);
        //BufferedWriter bw = new BufferedWriter(OWS);

        BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;

        while((line= buffr.readLine())!=null){
            if("over".equals(line))
                break;
            else
            {
                buffw .write(line.toUpperCase());
                buffw .newLine();
                buffw .flush();
            }
        }


    }

}
