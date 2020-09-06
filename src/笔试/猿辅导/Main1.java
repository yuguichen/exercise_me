package 笔试.猿辅导;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] num = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            num[i] = in.nextInt();
            if(!map.containsKey(num[i]))
                map.put(num[i],1);
            else
                map.put(num[i],map.get(num[i])+1);
        }

        for(int i=0;i<n;i++){
            if(map.get(num[i])<=m)
                System.out.print(num[i]+" ");
        }
    }

}
