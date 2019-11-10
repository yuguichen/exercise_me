package 笔试.滴滴;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        if(m==1){
            Arrays.sort(arr);
            System.out.println(arr[0]);
        } else{

            int[][] dp = new int[m+1][n];
            for(int i=0;i<n;i++){
                dp[0][i]= 0;
            }

            for(int i=0;i<m+1;i++){
                for(int j=0;j<n;j++){

                }
            }
        }




    }
}


