package 笔试.旷世;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.MAX_VALUE;

        int num = 0;
        while(n>0){
            num+=(n&1);
            n=n>>1;
        }
        System.out.println(num);


    }


}
