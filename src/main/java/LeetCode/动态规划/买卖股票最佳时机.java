package LeetCode.动态规划;


public class 买卖股票最佳时机 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;

        int dp[] = new int[prices.length];
        int max = 0;

        for(int i=1;i<prices.length;i++){
            for(int j=i-1;j>=0;j--){
                int temp = prices[i]-prices[j];
                if(temp>0 && dp[j]+temp>dp[i])
                    dp[i] = dp[j]+temp;
            }
            max = max>dp[i]?max:dp[i];
        }
        return max;
    }

    /**
     * 一次遍历 O(n)
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        if(prices.length==0)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
                continue;
            }
            if(maxProfit<prices[i]-minPrice)
                maxProfit = prices[i]-minPrice;
        }
        return maxProfit;
    }

    /**
     * 多笔交易
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
     *       这笔交易所能获得利润 = 5-1 = 4 。
     *       随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
     *      这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     */
    public int maxProfit_3(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int start = 0;
        int maxProfit = 0;
        int i;
        for(i=0;i<prices.length-1;i++){
            if(prices[i]>prices[i+1]){
                maxProfit = prices[i]-prices[start]+maxProfit;
                start = i+1;
                continue;
            }
        }
        maxProfit = prices[i]-prices[start]+maxProfit;
        return maxProfit;
    }

    /**
     * 最多交易两次
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */

    public int maxProfit_4(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int K = 2;
        int[][][] dp = new int[prices.length][K+1][2];

        for(int i=0;i<prices.length;i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        dp[0][1][1] = -prices[0];
        dp[0][0][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;

        for(int i=1; i<prices.length;i++){
            dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
            dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
            dp[i][2][0] = max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);
            dp[i][2][1] = max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);
        }
        return dp[prices.length-1][K][0];
    }

    public int max(int a, int b){
        return a>b?a:b;
    }

}
