package acwing;

import java.util.Scanner;

public class 背包问题 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for(int i=0;i<N;i++){
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        System.out.println(solution_fullPackage(N,V,v,w));
    }

    /**
     * 01背包问题
     * @param N 物品总数
     * @param V 背包体积
     * @param v vi代表第i个物品体积
     * @param w wi代表第i个物品价值
     */
    public static int solution_01package(int N,int V ,int[] v,int[] w){
        int[] dp = new int[V+1];

        for(int i=0;i<N;i++){
            for(int j=V;j>=v[i];j--){
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }

        return dp[V];
    }

    /**
     *  完全背包
     * @param N 物品总数
     * @param V 背包体积
     * @param v vi代表第i个物品体积
     * @param w wi代表第i个物品价值
     * @return
     */
    public static int solution_fullPackage(int N,int V ,int[] v,int[] w){
        int[] dp = new int[V+1];

        for(int i=0;i<N;i++){
            for(int j=v[i];j<=V;j++){
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }

        return dp[V];
    }
}
