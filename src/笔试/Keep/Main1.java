package 笔试.Keep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    /**
     * 两个字符串是 s1和s2： 将s1打乱后在增加一个字符组成s2
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = "";
        String s2 = "a";

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char temp = s1.charAt(i);
            if(!map.containsKey(temp))
                map.put(temp,1);
            else
                map.put(temp,map.get(temp)+1);
        }

        for(int i=0;i<s2.length();i++){
            char temp = s2.charAt(i);
            if(!map.containsKey(temp)){
                System.out.println(temp);
                break;
            }
            int sum = map.get(temp)-1;
            if(sum < 0){
                System.out.println(temp);
                break;
            }
            map.put(temp,sum);
        }

    }

    /**
     * 异或
     */
    private static char solve(String input1, String input2){
        long result = 0;
        for (int i = 0; i < input1.length(); i++){
            result ^= input1.charAt(i);
        }
        for (int i = 0; i < input2.length(); i++){
            result ^= input2.charAt(i);
        }
        return (char) result;
    }

}
