package javaSE.IO;

import java.io.*;

/**
 * 将一个文本文件复制到另一个盘
 * 1、读取资源
 * 2、将读到的数据写入制定位置
 */
public class CopyTextTest {
    public static void main(String args[]) {
        File file_old = new File("F:\\老师课件\\6\\Lif.txt");
        File file_new = new File("G:\\Java学习\\javaSE.IO\\练习\\c.doc");

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            if(!file_new.exists())
                file_new.createNewFile();

            if (!file_old.exists()){
                file_old.createNewFile();
            }

            fileReader = new FileReader(file_old);
            fileWriter = new FileWriter(file_new);

            char[] cbuf = new char[1024];
            int ch=0;
            /**
             * 问题：fileReader.read(cbuf)读到最后返回-1
             *      为什么不跳出while循环，还能继续写入
             */
            while((ch=fileReader.read(cbuf))!=-1){

                //ch=fileReader.read(cbuf);
                //System.out.println(ch);
                fileWriter.write(cbuf,0,ch);
                fileWriter.flush();
                //System.out.println(cbuf.length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭输入输出流
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
