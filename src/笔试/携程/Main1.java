package 笔试.携程;

import java.util.Scanner;

public class Main1 {
    /**
     * LeetCode第410题：分割数组最大值
     * @param m
     * @param array
     * @return
     */
    static int schedule(int m,int[] array) {
        int result = 0;
        int[] sum = new int[m];
        int length = array.length;

        return result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
