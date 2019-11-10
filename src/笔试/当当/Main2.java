package 笔试.当当;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll(" ","");
        int length = s.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 1;
        for(int i=0;i<length;i++){
            char a = s.charAt(i);
            if(!hashMap.containsKey(a))
                hashMap.put(a,1);
            else{
                int temp = hashMap.get(a)+1;
                if(temp>max)
                    max = temp;
                hashMap.put(a,temp);
            }

        }

        System.out.println(max);


    }

}
