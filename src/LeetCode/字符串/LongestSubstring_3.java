package LeetCode.字符串;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3、无重复字符的最长子串
 */
public class LongestSubstring_3 {
    @Test
    public void test(){
        String s = "abcdefghijklmnopqrstuvwxyz0123456789";

        int length1 = lengthOfLongestSubstring(s);
        int length2 = lengthOfLongestSubstring2(s);
    }

    /**
     * 3、无重复字符的最长子串 2019-06-09
     * @param s
     * @return length
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int flag = 0;
        int i = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char c;

        for(;i<chars.length;i++){
            c = chars[i];
            if(map.containsKey(c) && map.get(c)>=flag){
                length = Math.max(length,i-flag);
                flag = map.get(c)+1;
            }
            map.put(c,i);
        }
        return Math.max(length,i-flag);
    }

    /**
     * 无重复字符的最长子串 2.0
     *      优势: 直接对数组操作，内存占用小，速度快
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int max = 0, left = 0 ,right = 0;

        for (; right < chars.length; right++) {
            char c = chars[right];
            for (int i = left; i < right; i++) {
                if(c == chars[i]) {
                    max = Math.max(max, right-left);
                    left = i + 1;
                }
            }
        }
        return Math.max(max, right-left);
    }

    public int lengthOfLongestSubstring3(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }
}
