package 笔试.字节跳动2;

import java.util.Scanner;

public class Main2 {

    // 8956145839260264192
    // 86 4566 3438 7510 4552
    //       4 0700 8023 8332
    //    3126 6031 9450 8912
    //247 7358 8001 6542 5658
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 70;
        if(n==0)
            System.out.println(0);
        else if(n == 2)
            System.out.println(1);
        else{
            int k = n/2;
            long[] dp = new long[k+1];

            dp[0] = 1l;
            dp[1] = 1l;
            for(int i=2;i<k+1;i++){
                int t = i/2;
                int index = i-1;
                while(t>0){
                    dp[i]+=(2*dp[index]*dp[i-1-index]);
                    t--;
                    index--;
                }

                if(i%2==1){
                    dp[i]+=dp[index];
                }
                dp[i] = dp[i];
            }
            System.out.println(dp[k]);
        }

    }

}
