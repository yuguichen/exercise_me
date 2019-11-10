package LeetCode.动态规划;

public class 面板平铺 {

    public int numTilings(int N) {
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        int mod = (int)Math.pow(10,9)+7;

        for(int i=2;i<=N;i++){
            for(int j=1;j<=i;j++){
                if(j<3)
                    dp[i] = (dp[i]+dp[i-j])%mod;
                else
                    dp[i] = (dp[i]+(2*dp[i-j])%mod)%mod;
            }
        }
        return dp[N];
    }

}
