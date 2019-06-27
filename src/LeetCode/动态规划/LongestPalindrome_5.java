package LeetCode.动态规划;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome_5 {

    @Test
    public void test(){
        String s = "babad";
        String palindrome =  longestPalindrome(s);
        System.out.println(palindrome);
    }

    /**
     * 动态规划方法
     *      核心：找到每次状态所依赖的上一个状态是什么；
     *      时间复杂度 O（n*n）
     *      空间复杂度 O（n*n）
     * @param s
     * @return
     */
    public String longestPalindrome_dp(String s) {
        if(s == null || s.length()<=1)
            return s;

        int length = s.length();
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        int l = 0;
        int start = 0;

        // 对一字回文和二字回文进行初始化,因为一字和二字回文不需要依赖
        for(int i=0; i<length;i++){
            dp[i][i] = true;
            if(i+1>=length)
                break;
            if( ss[i] == ss[i+1] ){
                dp[i][i+1] = true;
                if(l==0){
                    l = 1;
                    start = i;
                }
            } else
                dp[i][i+1] = false;
        }

        // 从三字回文开始遍历
        for(int i=2; i<length; i++){
            for(int j=0; j<length; j++){
                if(j+i>=length)
                    continue;

                if(dp[j+1][j+i-1] && ss[j]==ss[j+i]){
                    dp[j][j+i] = true;
                    if(i>l){
                        l = i;
                        start = j;
                    }
                } else
                    dp[j][j+i] = false;
            }
        }

        return s.substring(start,start+l+1);
    }

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length()<=1)
            return s;

        int length = s.length();
        int start = 0;
        int end = 0;

        for(int i=0; i<length; i++){
            int len1 = findPalindrome(s,i,i);
            int len2 = findPalindrome(s,i,i+1);
            int len = len1>len2? len1:len2;
            if( len>end-start ){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private int findPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; // 返回回文的长度
    }
}
