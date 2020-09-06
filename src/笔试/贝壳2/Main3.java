package 笔试.贝壳2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        long result = 0;
        for(int i=0; i<n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            while(a>0 && m>=b){
                m-=(long)b;
                result++;
                a--;
            }
        }
        System.out.println(result);

    }


}
