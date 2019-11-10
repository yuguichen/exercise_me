package 笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] x_y = new int[n][2];
        int M = 0;
        for(int i=0;i<n;i++){
            x_y[i][0] = in.nextInt();
            x_y[i][1] = in.nextInt();
            M += x_y[i][0];
        }

        int[] arr = new int[M];

        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<x_y[i][0];j++){
                arr[index++] = x_y[i][1];
            }
        }

        Arrays.sort(arr);

        int ans = 0;
        for(int i=0;i<M/2;i++){
            ans = Math.max(ans,arr[i]+arr[M-i-1]);
        }
        System.out.println(ans);

    }
}


