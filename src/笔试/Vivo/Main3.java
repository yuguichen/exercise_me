package 笔试.Vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        int sum = 0;
        for(int i=0;i<input.length;i++){
            sum+=input[i];
        }

        int[][] dp = new int[input.length+1][sum/2+1];

        for(int i=0;i<=input.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=sum/2+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=input.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>input[i-1])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-input[i-1]]+input[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return sum-2*dp[input.length][sum/2];
    }
}
