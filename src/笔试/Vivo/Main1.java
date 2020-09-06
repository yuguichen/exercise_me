package 笔试.Vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1 {

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

        if(input== null || input.length == 0)
            return -1;
        if(input.length == 1)
            return 0;

        int[] dp = new int[input.length];
        dp[0] = 0;

        for(int i=1;i<input.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--){
                if(input[j]>=i-j)
                    dp[i] = Math.min(dp[i],dp[j]+1);
            }
        }

        if( dp[input.length-1]==Integer.MAX_VALUE )
            return -1;
        return dp[input.length-1];
    }


}
