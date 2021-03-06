package 数据结构与算法.查找;

import utils.InandOutUtils.StdIn;
import utils.InandOutUtils.StdOut;
import 数据结构与算法.bean.ST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCounter {

    public static void main(String[] args) throws IOException {
        int minlen = Integer.parseInt(args[0]);
        counter2(minlen);
        counter(minlen);
    }

    public static void counter2( int minlen ) throws IOException {
        ST<String,Integer> st = new ST<>();
        BufferedReader br = new BufferedReader(new FileReader("G:\\files\\tale.txt"));

        String line = null;
        String reg1 = "\\s+"; // \\s表示 空格,回车,换行等空白符 +号表示一个或多个
        String reg2 ="\\w+";
        while ((line=br.readLine())!=null){
            String str[] = line.toLowerCase().split(reg1);//将读取的文本进行分割
            for(String word: str){
                //StdOut.println(word);
                word = word.replaceAll("[\\pP]","");
                //StdOut.println(word);
                if(word.matches(reg2)){
                    //if(word.length()<minlen) continue;
                    if(!st.contains(word)) st.put(word,1);
                    else st.put(word,st.get(word)+1);
                }
            }
        }

        String max = "";
        st.put(max,0);
        int wordNum =0;
        for(String word:st.keys()){
            wordNum += st.get(word);
            if(st.get(word)>st.get(max))
                max = word;
        }
        StdOut.println("wordNum" + wordNum);
        StdOut.println("max"+" "+max+":"+st.get(max));
    }

    public static void counter(int minlen){
        ST<String,Integer> st = new ST<>();

        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length()<minlen) continue;
            if(!st.contains(word)) st.put(word,1);
            else st.put(word,st.get(word)+1);
        }

        String max = "";
        st.put(max,0);
        for(String word:st.keys()){
            if(st.get(word)>st.get(max))
                max = word;
        }

        StdOut.println("max"+" "+max+":"+st.get(max));
        //StdOut.println("business"+st.get("business"));
        int wordNum =0;
        for(String word:st.keys()){
            wordNum += st.get(word);
            //StdOut.print(word+":"+st.get(word)+"][");
        }
        StdOut.println("wordNum" + wordNum);
    }
}
