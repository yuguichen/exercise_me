package 笔试.Keep;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            String s = in.nextLine();

            boolean result = check(s);
            if (result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    public static boolean check(String s){

        if(s.length()<8 || (s.charAt(0)>='0'&& s.charAt(0)<='9'))
            return false;

        char[] chars = s.toCharArray();

        int hasD = 0;
        int hasX = 0;
        int hasS = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='a' && chars[i]<='z')
                hasX = 1;
            else if(chars[i]>='A' && chars[i]<='Z')
                hasD = 1;
            else if(chars[i]>='0' && chars[i]<='9')
                hasS = 1;
            else
                return false;
        }

        return (hasD+hasX+hasS)>1;
    }
}
