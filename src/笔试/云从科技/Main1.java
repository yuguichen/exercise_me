package 笔试.云从科技;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = "[],9";

        String[] ss = s.split("],");
        if(ss.length <2)
            System.out.println(-1);
        else {
            int target = Integer.parseInt(ss[1]);
            ss[0] = ss[0].replaceAll("\\[","");
            String[] sss = ss[0].split(",");

            if(sss.length==0 || sss[0].equals(""))
                System.out.println(-1);
            else{
                int[] arr = new int[sss.length];
                for(int i=0;i<sss.length;i++){
                    arr[i] = Integer.parseInt(sss[i]);
                }

                quick(arr,0,arr.length-1);

                int result = find(target,arr,arr.length);
                System.out.println(result);
            }

        }
    }

    public static int find(int target,int[] arr,int n){
        if(n == 0)
            return -1;

        int result = -1;
        int lo = 0;
        int hi = n-1;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            if(arr[mid]>target)
                hi = mid-1;
            else if(arr[mid]<target)
                lo = mid +1;
            else{
                result =  mid;
                break;
            }
        }
        while(result-1>=0 && arr[result] == arr[result-1])
            result--;
        return result;
    }

    public static void quick(int[] arr, int lo, int hi){
        if(lo>hi)
            return;
        int i = lo;
        int j = hi;
        int temp = arr[lo];

        while(i<j){
            while(i<j && arr[j]>=temp)
                j--;
            if(i<j)
                arr[i++] = arr[j];

            while(i<j && arr[i]<=temp)
                i++;
            if(i<j)
                arr[j--] = arr[i];
        }
        arr[i] = temp;
        quick(arr,lo,i-1);
        quick(arr,i+1,hi);

    }
}
