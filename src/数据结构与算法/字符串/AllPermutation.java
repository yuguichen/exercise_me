package 数据结构与算法.字符串;

import org.junit.Test;
import 数据结构与算法.Utils.SortUtil;
import 数据结构与算法.排序.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 字符串全排列
 */
public class AllPermutation {

    @Test
    public void test(){
        String a = "scd";
        char[] chars = a.toCharArray();
        // 递归方法
        Set<String> list1 = permutation(chars,0,chars.length-1);
        System.out.println("递归方法:"+list1.size());
        list1.stream().forEach(System.out::println);

        String b = "1232";
        //非递归方法
        Set<String> list2 = permutation(b);
        System.out.println("非递归方法:"+list2.size());
        list2.stream().forEach(System.out::println);

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
    public Set<String> permutation(char[] chars, int start, int end){

        Set<String> stringSet = new TreeSet<>();
        Set<Character> set = new TreeSet<>();
        if(start == end){
            stringSet.add(String.valueOf(chars));
            return stringSet;
        }

        for(int i=start; i<=end;i++){
            if(set.contains(chars[i]))
                continue;
            set.add(chars[i]);

            swap(chars,start,i);
            stringSet.addAll(permutation(chars,start+1,end));
            swap(chars,start,i);
        }
        return stringSet;
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 非递归方法
     *      先将字符串按自然序排列(升序)；
     *      然后每次找到一个比前一个大一点的排序；
     *      直到最后一个为自然降序排列；
     * 不必单独考虑重复字符情况
     */
    public Set<String> permutation(String str){
        Set<String> stringSet = new TreeSet<>();
        char[] chars = str.toCharArray();
        Character[] characters = new Character[chars.length];
        for(int i=0;i<chars.length;i++){
            characters[i] = chars[i];
        }

        //1、按自然升序排序
        QuickSort.threeWayQuickSort(characters,0,characters.length-1);

        //2、每次找到一个比前一个大一点的排序；
        int length = characters.length;
        stringSet.add(arrayToString(characters).toString());
        while( !SortUtil.isSorted(characters,"desc") ){
            int i = length -1;
            // 找到第一个 characters[i-1]< characters[i]
            while( !SortUtil.less(characters[i-1],characters[i]) && i>0 ){
                i--;
            }
            // characters[i-1]和比characters[i-1]大的最小的那个元素（倒着数第一个比它大的）交换
            for(int j=length-1; j>=i-1; j--){
                if(SortUtil.less(characters[i-1],characters[j])){
                    SortUtil.exch(characters, i-1, j);
                    break;
                }
            }
            reverse(characters,i,length-1);
            stringSet.add(arrayToString(characters).toString());
        }
        return stringSet;
    }

    /**
     * 翻转
     * @param characters
     * @param start
     * @param end
     */
    private void reverse(Character[] characters, int start, int end){
        while(start<end){
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
    }


    private StringBuilder arrayToString(Character[] characters){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<characters.length; i++){
            str.append(characters[i]);
        }
        return str;
    }
}
