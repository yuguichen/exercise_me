package 笔试.滴滴;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] tj = new int[m][2];

        for(int i=0; i<m;i++){
            tj[i][0] = in.nextInt()-1;
            tj[i][1] = in.nextInt()-1;
            if(tj[i][0]>tj[i][1]){
                int temp =  tj[i][0];
                tj[i][0] =  tj[i][1];
                tj[i][1] = temp;
            }
        }
        quick(tj,0,m-1);

        int[] flag = new int[n];

        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(tj[j][0] == i){
                    flag[tj[j][1]] = flag[i]+1;
                }
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(flag[i]))
                map.put(flag[i],1);
            else
                map.put(flag[i],map.get(flag[i])+1);
        }

        int[] temp = new int[map.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            temp[i++] = entry.getValue();
        }

        Arrays.sort(temp);
//        int result = 0;
//        for(i=0;i<temp.length;i++){
//            if(temp[i]*2<=n)
//                result = Math.max(result,temp[i]*2);
//        }
        if(n<=2)
            System.out.println(n);
        else if(temp.length>1)
            System.out.println(temp[temp.length-1]*2);
        else
            System.out.println(temp[0]%2==0?temp[0]:temp[0]-1);


    }

    private static void quick(int[][] arr, int lo, int hi){
        if(lo>hi)
            return;
        int i = lo;
        int j = hi;
        int temp = arr[lo][0];

        while(i<j){
            while(i<j && arr[j][0]>=temp)
                j--;
            if(i<j){
                arr[i++] = arr[j];
            }

            while(i<j && arr[i][0]<=temp)
                i++;
            if(i<j){
                arr[j--] = arr[i];
            }

        }
        arr[i] = arr[lo];
        quick(arr,lo,i-1);
        quick(arr,i+1,hi);

    }


}
