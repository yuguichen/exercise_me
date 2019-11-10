package 笔试.云从科技;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        if(s1.length() == 0)
            System.out.println(s2);
        else if(s2.length()==0)
            System.out.println(s1);
        else{
            if(s1.length()>s2.length()){
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
            // l1<l2

            int len1 = s1.length();
            int len2 = s2.length();
            int flag = 0;
            int[] result = new int[len2];

            for(int i=0;i<len2;i++){
                int a =0;
                if(i<len1)
                     a = s1.charAt(len1-1-i)-'0';

                int b = s2.charAt(len2-1-i)-'0';
                int temp = a+b+flag;
                result[len2-1-i] = temp%10;
                flag = temp/10;
            }

            StringBuilder results = new StringBuilder();
            if(flag == 1)
                results.append(1);

            for(int i=0;i<len2;i++){
                results.append(result[i]);
            }
            System.out.println(results.toString());

        }



    }
}
