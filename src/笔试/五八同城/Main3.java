package 笔试.五八同城;

import java.util.Scanner;

public class Main3 {
    private static final char[] ch = {'M','A','S','K'};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String[] s = in.nextLine().split("@");

            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<s[0].length();i++){
                stringBuilder.append(s[0].charAt(i));
                if(i!=s[0].length()-1)
                    stringBuilder.append(ch[i%4]);
            }
            stringBuilder.append("@");
            stringBuilder.append(s[1]);

            System.out.println(stringBuilder.toString());
        }


    }
}
