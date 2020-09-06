package LeetCode.动态规划;

import java.util.*;

public class K站中转内最便宜的航班 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+1];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);

        Arrays.fill(dp[src],0);
        for(int[] flight:flights){
            if(flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }

        for(int i=1;i<=K;i++){
            for(int[] flight:flights){
                if(dp[flight[0]][i-1]!=Integer.MAX_VALUE){
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i],dp[flight[0]][i-1]+flight[2]);
                }
            }
        }

        if(dp[dst][K]!=Integer.MAX_VALUE)
            return dp[dst][K];
        else
            return -1;
    }
}
