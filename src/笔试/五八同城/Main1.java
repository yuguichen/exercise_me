package 笔试.五八同城;

import java.util.Scanner;

public class Main1 {
    private static final char[] temp =
            {'0','1','2','3','4','5','6','7','8','9',
                    '`','!','@','#','$','%','^','&',
                    '*','(',')','{','}','\\','<','>','?'};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String s = "";
        if(n==0)
            s = "0";
        while(n>0){
            int t = (int)(n%27);
            s=temp[t]+s;
            n = n/27;
        }


        System.out.println(s);
    }


}
