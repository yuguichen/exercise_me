package 笔试.Keep;

import java.util.Scanner;

/**
 * keep 推出3种指导方案：
 *      1、一次购买一天指导；
 *      2、一次购买7天指导；
 *      3、一次购买30天指导
 *  根据输入的需要指导的天数days[] (days[i]<=365);
 *           和每种方案花费 costs[];
 *   计算如何购买是总花费最少？
 */
public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] ss = in.nextLine().split(",");
        String[] costcost = in.nextLine().split(",");

        if(ss.length==0 || ss[0]=="")
            System.out.println(0);
        else{
            int[] days = new int[ss.length];
            for(int i=0;i<ss.length;i++){
                days[i] = Integer.parseInt(ss[i]);
            }

            int[] costs = new int[3];
            for(int i=0;i<3;i++){
                costs[i] = Integer.parseInt(costcost[i]);
            }

            int result = solution(days,costs);
            System.out.println(result);
        }

    }

    public static int solution(int[] days, int[] costs){
        int[] dp = new int[days[days.length-1]+1];

        dp[0] = 0;
        int j = 0;
        for(int i=1;i<dp.length;i++){

            if(j<days.length && i<days[j]){
                // 当天不需要指导，花费保持和前一天一致
                dp[i] = dp[i-1];
            } else {
                int lastDay = days[j++];
                int oneDayTicket = lastDay-1>0?dp[lastDay-1]+costs[0]:costs[0];
                int weekTicket   = lastDay-7>0?dp[lastDay-7]+costs[1]:costs[1];
                int monthTicket  = lastDay-30>0?dp[lastDay-30]+costs[2]:costs[2];
                dp[i] = Math.min(oneDayTicket,Math.min(weekTicket,monthTicket));
            }
        }
        return dp[dp.length-1];
    }
}
