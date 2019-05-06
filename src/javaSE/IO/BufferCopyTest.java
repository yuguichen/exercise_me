package javaSE.IO;

import java.io.*;

public class BufferCopyTest {
    public static void main(String args[]) throws IOException{
        File file_old = new File("F:\\老师课件\\6\\Lif.txt");
        File file_new = new File("G:\\Java学习\\javaSE.IO\\练习\\c.doc");

        if(!file_new.exists())
            file_new.createNewFile();

        FileWriter fileWriter = new FileWriter(file_new);
        FileReader fileReader = new FileReader(file_old);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String ch;
        while((ch=bufferedReader.readLine())!= null){
            bufferedWriter.write(ch);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //关闭输入输出流
        bufferedReader.close();
        bufferedWriter.close();
    }

}


