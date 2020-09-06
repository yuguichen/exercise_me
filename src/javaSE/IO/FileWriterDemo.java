package javaSE.IO;

import java.io.IOException;
import java.io.FileWriter;


/**
 *
 */
public class FileWriterDemo {

    private static final String LINE_SEPARATOR =System.lineSeparator();

    public static void main(String args[]) throws IOException{

        FileWriter fileWriter = new FileWriter("ZUOYE.TXT",true);

        fileWriter.write(   "abcde"+LINE_SEPARATOR+"hahahha");
        fileWriter.flush();

    }

}
