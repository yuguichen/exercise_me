package 笔试.流利说;

import java.util.Scanner;

/**
 * 有N级台阶，每次可能上一级或二级。共有多少种上法？
 */
public class Main2 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();

        int result = solution(4);
        System.out.println(result);
    }

    public static int solution(int n){

        if(n<=1)
            return n;

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
