package LeetCode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 */
public class Z字形变换 {
    private static final boolean UP = true;
    private static final boolean DOWN = false;

    public static String convert(String s, int numRows) {

        if(numRows ==1)
            return s;

        StringBuilder[] lists = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)
            lists[i] = new StringBuilder();

        char[] chars = s.toCharArray();
        boolean flag = true;
        for(int i=0,temp=0; i<s.length(); i++){
            lists[temp].append(chars[i]);

            if(flag)
                temp++;
            else
                temp--;
            if(temp==numRows-1 || temp==0)
                flag = !flag;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            sb.append(lists[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args){
        String s ="LEETCODEISHIRING";
        int numRows = 4;
        String result = convert(s,numRows);
        System.out.println(result);

    }
}
