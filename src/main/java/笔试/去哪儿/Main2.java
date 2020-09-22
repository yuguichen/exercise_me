package 笔试.去哪儿;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 0)
            System.out.println(1);
        else {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i=2;i<=n;i++){
                for(int j =i;j>0;j--){
                    dp[j] = dp[j]+dp[j-1];
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<=n;i++){
                stringBuilder.append(dp[i]+" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }

}
