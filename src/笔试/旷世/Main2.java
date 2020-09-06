package 笔试.旷世;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int result = solution( s, n);

        System.out.println(result);

    }

    public static int solution(String s,int n){
        int maxLength = 0;
        int start =0;
        int end =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c)+1);

            end = i;

            while(map.size()>n){
                int temp = map.get(s.charAt(start))-1;
                if(temp == 0)
                    map.remove(s.charAt(start));
                else
                    map.put(s.charAt(start),temp);

                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }


}
