package 笔试.华为;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(checkChar(temp))
                continue;
            else if(temp == '-'){
                if(i-1>=0 && i+1<s.length() &&
                        checkChar(s.charAt(i+1)) && checkChar(s.charAt(i-1))){
                    continue;
                } else {
                    if(i+1<s.length())
                        s = s.substring(0,i)+" "+s.substring(i+1,s.length());
                    else
                        s = s.substring(0,i);
                }
            } else if(" ".equals(temp)) {
                continue;
            } else {
                if(i+1<s.length())
                    s = s.substring(0,i)+" "+s.substring(i+1,s.length());
                else
                    s = s.substring(0,i);
            }
        }

        s= s.replaceAll("\\s+"," ").trim();
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =ss.length-1;i>=0;i--){
            sb.append(ss[i]+" ");
        }
        System.out.println(sb.toString().trim());

    }

    public static boolean checkChar(char temp){
        if((temp<='9'&&temp>='0')||(temp<='z'&&temp>='a')||(temp<='Z'&&temp>='A'))
            return true;
        else
            return false;
    }
}
