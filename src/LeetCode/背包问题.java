package LeetCode;

import org.junit.Test;

public class 背包问题 {

    @Test
    public void test_getMaxEngine(){
        int V = 100;
        int M = 15;
        int N = 5;
        int[] volume = {50,40,30,20,10};
        int[] weight = {1,2,3,9,5};
        int[] engine = {300,480,270,200,180};
        getMaxEngine(volume, weight, engine, V, M,  N);
    }

    /**
     * 核电站反应堆容器最大体积 V； 最大重量 M, 材料数量 N
     * volume[] : 每个材料的体积；
     * weight[] : 每个材料的重量；
     * engine[] : 每个材料的能量；
     */
    public void getMaxEngine(int[] volume, int[] weight, int[] engine,int V, int M, int N){
        int dp[][] = new int[M+1][V+1];

        for(int i=0;i<M;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<V;i++){
            dp[0][i] = 0;
        }

        // M和V采用逆循环，保证决定当前状态的条件始终为前一状态，
        //                 避免本轮状态对后续状态产生影响；
        for(int n=0;n<N;n++){
            for(int m=M;m>=1;m--){
                for(int v=V;v>=1;v--){
                    if(m>=weight[n] && v>=volume[n])
                        dp[m][v] = max(dp[m][v],dp[m-weight[n]][v-volume[n]]+engine[n]);
                }
            }
        }
        System.out.println(dp[M][V]);

    }

    public int max(int a, int b){
        return a>b?a:b;
    }
}
