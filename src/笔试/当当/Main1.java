package 笔试.当当;

import java.util.Scanner;


public class Main1 {


    public static String[] danwei = {"元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万","拾","佰","仟"};
    public static char[] shuzi = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        long n = 4234120024453l;
        int i=0;
        String s = "";

        while(n!=0){
            long temp = n%10;
            StringBuilder sb = new StringBuilder();
            sb.append(shuzi[(int)temp]);

            if(temp!=0)
                sb.append(danwei[i]);

            i++;
            sb.append(s);
            s = sb.toString();
            n=n/10;
        }
        while (s.contains("零零"))
            s.replaceAll("零零","零");

        s+="整";
        System.out.println(s);
    }


}
