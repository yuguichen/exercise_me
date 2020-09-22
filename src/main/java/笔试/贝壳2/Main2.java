package 笔试.贝壳2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int k = 4;
        String s = "aaaa";
        int n = s.length();

        int maxLength = 0;
        for(int i=1;i<n;i++){
            int len = 0;
            int j = i;
            int index = 0;
            while(j<n && s.charAt(index) == s.charAt(j)){
                len++;
                if(j == s.length()-1){
                    maxLength = len;
                    System.out.println(maxLength);
                    break;
                }

                index++;
                j++;
            }
            if(maxLength>0)
                break;
        }

        String result = getString(s,s.substring(maxLength,s.length()),k);
        System.out.println(result);

    }


    public static String getString(String s, String same,int k){
        StringBuilder stringBuilder = new StringBuilder(s);

        for(int i=0;i<k-1;i++){
            stringBuilder.append(same);
        }
        return stringBuilder.toString();
    }
}
