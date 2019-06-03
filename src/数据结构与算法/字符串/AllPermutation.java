package 数据结构与算法.字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串全排列
 * 解决思想：递归
 */
public class AllPermutation {

    @Test
    public  void test(){
        String a = "112";
        char[] chars = a.toCharArray();
        permutation(chars,0,chars.length-1).stream().forEach(System.out::println);
    }

    /**
     *  递归思想：
     *      依次取每个字符固定位前缀，然后对其余字符进行排序（通过递归方式处理）；
     *      处理后将字符串还原，进入下一次循环，保证字符位置不变；
     *      递归终止条件：
     *          当最后只有一个字符排序时，只有一种情况，则终止返回；
     * @param chars
     * @param start
     * @param end
     * @return
     */
    public List<String> permutation(char[] chars, int start, int end){
        List<String> stringList = new ArrayList<>();

        if(start == end){
            stringList.add(String.valueOf(chars));
            return stringList;
        }

        for(int i=start; i<=end;i++){
            if(chars[start] == chars[i] && start != i)
                continue;
            swap(chars,start,i);
            stringList.addAll(permutation(chars,start+1,end));
            swap(chars,start,i);
        }

        return stringList;
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
