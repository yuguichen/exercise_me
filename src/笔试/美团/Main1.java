package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];
//        for(int i=0; i<n; i++){
//            a[i] = in.nextInt();
//        }
        int n= 11;
        int[] a ={3,9,5,1,6,9,8,2,4,5,10};
        int maxLength = solution(n,a);

        System.out.println(maxLength);
    }

    public static int solution(int n, int[] a){

        int maxLength = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++){
            for(int j=i; j>=0; j--){
                if(a[i]>a[j]){
                    dp[i] = Integer.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int i=0; i<n; i++)
            if(dp[i] >maxLength)
                maxLength = dp[i];

        return maxLength;
    }


}
