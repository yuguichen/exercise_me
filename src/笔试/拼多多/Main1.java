package 笔试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        long sum = 0L;
        for(int i=0;i<m;i++){
            sum +=(long)(arr[i]*arr[2*m-1-i]);
        }
        System.out.println(sum);

    }


}
