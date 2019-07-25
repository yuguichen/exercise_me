package 数据结构与算法.排序;

import utils.SortUtil;

/**
 * 选择排序
 * 时间复杂度：O(N*N/2)且运行时间与输入元素顺序无关
 *
 */
public class SelectSort {
    public static void main(String[] args){
        Integer[] a = new Integer[20];
        for(int i=0;i<20;i++){
            a[i] = (int)(Math.random() * 100);
        }
        for(int i=0;i<20;i++){
            System.out.print(a[i]+",");
        }
        System.out.println();
        sort(a);
        for(int i=0;i<20;i++){
            System.out.print(a[i]+",");
        }
    }
    // 升序排列
    public static void sort(Comparable[] a){
        int length = a.length;
        for(int i=0;i<length;i++){
            int min = i;
            for(int j=i+1;j<length;j++){
                if(SortUtil.less(a[j],a[min]))
                    min = j;
            }
            SortUtil.exch(a,i,min);
        }
    }

    public static void sort1(int[] a){
        int length = a.length;
        for(int i=0;i<length;i++){
            int min = i;
            for(int j=i+1;j<length;j++){
                if(a[j]<a[min])
                    min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
