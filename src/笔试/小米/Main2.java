package 笔试.小米;

import java.util.Arrays;

public class Main2 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {

        if(prices.length==0)
            return -1;

        Arrays.sort(prices);
        // 状态数组
        int[] dp = new int[budget+1];
        dp[0] = 0;

        // 初始化
        for(int j=1;j<=budget;j++){
            dp[j] = j%prices[0]==0 ? j/prices[0] : -1;
        }

        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=budget;j++){
                int a = dp[j];
                int b = j-prices[i]>=0 ? dp[j-prices[i]] : -1;
                dp[j] = a==-1 ? (b==-1 ? -1:b+1) : (b==-1 ? a:Math.min(a,b+1));
            }
        }

        return dp[budget];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){


        int[] _prices = {1,5,7,10};
        int budget =108;


        int res = solution(_prices, budget);
        System.out.println(String.valueOf(res));

    }
}
