package LeetCode.字符串;

/**
 * 214.给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
 *     找到并返回可以用这种方式转换的最短回文串。
 *     示例 1:
 *          输入: "aacecaaa"
 *          输出: "aaacecaaa"
 */
public class ShortestPalindrom_214 {

    public String shortestPalindrome(String s) {
        if(s == null || s.length()<=1)
            return s;

        int length = s.length();
        int flag = length-1;

        for(; flag>=0; flag--){
            if(isPalindrome(s,0,flag)){
                break;
            }
        }

        String temp = s.substring(flag+1,length);
        StringBuffer sb = new StringBuffer();
        for(int i=temp.length()-1; i>=0; i--){
            sb.append(temp.charAt(i));
        }

        return sb.toString()+s;
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if( s.charAt(start)!=s.charAt(end) ){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * 8ms 范例
     */

    public String shortestPalindrome_LeetCode(String s) {
        if(s.isEmpty())
            return s;
        char[] chs = s.toCharArray();
        int[] next = findNext(chs);
        int pi = 0;
        int si = chs.length - 1;
        while (pi < si){
            if(chs[pi] == chs[si]){
                ++pi;
                --si;
            }else{
                pi = next[pi];
                if(pi == -1) {
                    ++pi;
                    --si;
                }
            }
        }
        int end = (si + 1) << 1;
        if( pi == si )
            --end;
        StringBuffer buffer = new StringBuffer();
        for(int ci = chs.length -1; ci >= end; --ci)
            buffer.append(chs[ci]);
        buffer.append(s);
        return buffer.toString();
    }

    private int[] findNext(char[] chs) {
        int[] next = new int[chs.length];
        next[0] = -1;
        int i = 0;
        int k = -1;
        while (i + 1 < chs.length){
            if(k == -1 || chs[i] == chs[k]){
                next[++i] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
