package javaSE.IO;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

    public static void main(String args[]) {

        File file = new File("ZUOYE.TXT");

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int ch=0;
            while((ch=fileReader.read())!=-1)
                System.out.print(ch+" ");

            while((ch=fileReader.read())!=-1)
                System.out.print((char)ch);

            System.out.println();
            System.out.println("文件长度："+file.length());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
