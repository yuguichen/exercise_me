package 笔试.iHandy;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int m =in.nextInt();
        int n = in.nextInt();
        int[][] a = new int[m][n];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j =0 ;j<n;j++){
                a[i][j] = in.nextInt();
                if(!map.containsKey(a[i][j]))
                    map.put(a[i][j],1);
                else
                    map.put(a[i][j],map.get(a[i][j])+1);
            }
        }

        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            key.add(entry.getKey());
            value.add(entry.getValue());
        }

        int[] keykey = new int[key.size()];
        int[] val = new int[value.size()];


        int i=0;
        for(Integer k:key){
            keykey[i++] = k;
        }
        i=0;
        for(Integer v:value){
            val[i++] = v;
        }

        quick(val,0,val.length-1,keykey);

        String s = "";
        for(int j=0;j<keykey.length;j++){
           s+=keykey[j];
           s+=" ";
        }
        System.out.println(s.trim());

    }


    private static void quick(int[] arr, int lo, int hi,int[] key){
        if(lo>hi)
            return;
        int i = lo;
        int j = hi;
        int temp = arr[lo];
        int tempKey = key[lo];

        while(i<j){
            while(i<j && arr[j]<=temp)
                j--;
            if(i<j){
                arr[i] = arr[j];
                key[i] = key[j];
                i++;
            }


            while(i<j && arr[i]>=temp)
                i++;
            if(i<j){
                arr[j] = arr[i];
                key[j] = key[i];
                j--;
            }

        }
        arr[i] = temp;
        key[i] = tempKey;
        quick(arr,lo,i-1,key);
        quick(arr,i+1,hi,key);

    }

}
