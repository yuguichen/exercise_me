package javaSE.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamCopyTest {

    public static void main(String args[]) throws IOException{
        File file1 = new File("F:\\迅雷下载\\[电影天堂www.dygod.cn].鹿鼎记II神龙教.rmvb");
        File file2 = new File("G:\\Java学习\\JavaSE基础视频21、javaSE.IO\\练习\\鹿鼎记II神龙教.rmvb");

        FileInputStream FIS = new FileInputStream(file1);
        FileOutputStream FOS = new FileOutputStream(file2);

        byte[] buf = new byte[1024];
        int len = 0;

        while ((len=FIS.read(buf))!=-1) {
            FOS.write(buf,0,len);
        }

        FIS.close();
        FOS.close();

    }
}
