package 笔试.腾讯;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            if(n<11)
                System.out.println("NO");
            else if(n==11){
                if(s.charAt(0)=='8')
                    System.out.println("YES");
                else
                    System.out.println("NO");
            } else {
                String temp = s.substring(0,n-10);
                if(temp.contains("8"))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }

        }
    }

}
