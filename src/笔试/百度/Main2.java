package 笔试.百度;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextLong();
        }

        Arrays.sort(arr);

        if(arr[n-1]<n)
            System.out.println(0);
        else {
            int result = 0;
            while(arr[n-1]>=n){
                result++;
                arr[n-1] =arr[n-1]-n;
                for(int i=0;i<n-1;i++){
                    arr[i] = arr[i]+1;
                }
                tiaozhen(arr);
            }
            System.out.println(result);
        }
    }

    public static void tiaozhen(long[] arr){
        int n = arr.length-1;
        long temp = arr[n];

        for(int i=n-1;i>=0;i--){
            if(arr[i]>temp)
                arr[i+1] = arr[i];
            else {
                arr[i+1] = temp;
                break;
            }
        }
    }
}


