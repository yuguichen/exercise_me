package javaSE.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流学习
 *
 */

public class IOStreamDemo {
    public static void main (String args[]) throws IOException{

        File file = new File("G:\\Java学习\\JavaSE基础视频21、javaSE.IO\\练习\\d.doc");

        FileInputStream fis = new FileInputStream(file);

        byte buf[]=new byte[fis.available()];//慎用，若文件过大则占用内存过多
        fis.read(buf);
        System.out.println(new String(buf));

        fis.close();

        FileOutputStream fos = new FileOutputStream(file);

        fos.write("abcdefg".getBytes());//FileOutputStream只能对字节数据进行操作

        fos.close();



    }
}
