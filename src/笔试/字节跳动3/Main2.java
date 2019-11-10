package 笔试.字节跳动3;

import java.util.Scanner;

/**
 * 判断  a+b>c
 */
public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()){
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();

            boolean flag = solution(a,b,c);
            System.out.println(flag);
        }
    }

    public static boolean solution(long a, long b, long c){

        if(a>=0 && b>=0){
            if(c<0)
                return true;
            if(c==0 && (a!=0||b!=0))
                return true;

            if(c>0 && a+b<0)
                return true;

            if(a+b-c>0)
                return true;

            return false;
        }

        if(a<=0 && b<=0){
            if(c>=0)
                return false;
            else {
                if(-a-b<0 || a+b-c<=0)
                    return false;

                return true;
            }
        }

        long temp = a+b;
        if(temp>=0){
            if(c<0 || (c>=0 && temp-c>0))
                return true;
            return false;
        } else {
            if(c>=0 || temp-c<=0)
                return false;
            return true;
        }
    }

}
