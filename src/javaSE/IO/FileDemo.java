package javaSE.IO;

import java.io.*;

public class FileDemo {
    public static void main(String args[]) throws IOException {
        File file = new File("G:\\Java学习\\JavaSE基础视频21\\练习\\new.txt");
        if(!file.exists()){

            File parentFile = file.getParentFile();
            if (!parentFile.mkdirs() || !parentFile.isDirectory()){
                throw new IOException("not a Directory");
            }
            file.createNewFile();//存在异常,加上上面的代码
        }


        FileWriter fileWriter1 = new FileWriter(file,false);
        fileWriter1.write(  "abcdefagggrrehhhhhfffffffffffffffffffffff");
        fileWriter1.flush();

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.length());

        /**
         * 练习读取文件内容并在控制台输出
         */
        FileReader fileReader = new FileReader(file);
        PrintStream fileWriter = System.out;
        int ch=0;
        while((ch = fileReader.read())!=-1){
            fileWriter.write((char)ch);
            fileWriter.flush();
        }
        fileReader.close();
        fileWriter .close();


        File file1 = new File(file.getParent(),"new1.txt");
        if(!file1.exists()) {
            file1.createNewFile();
        }
    }
}
