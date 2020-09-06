package 笔试.bilibili;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String word1 = "abc";
        String word2 = "abd";

        int result = solution(word1,word2);
        System.out.println(result);
    }

    public static int solution(String word1,String word2){
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j = 0;j<=len2;j++){
                if(i==0){
                    dp[i][j] = j;
                } else if(j==0){
                    dp[i][j] = i;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }

            }
        }
        return dp[len1][len2];
    }
}
