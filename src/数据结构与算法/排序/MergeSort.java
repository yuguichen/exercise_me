package 数据结构与算法.排序;

import 数据结构与算法.Utils.SortUtil;

/**
 * 归并排序
 *  时间复杂度 O(N*lgN)
 *  空间复杂度 O（N）
 */
public class MergeSort {
    public static void main(String[] args){

        Integer[] a = SortUtil.randn(20,100);
        SortUtil.show(a);
        sort(a,0,a.length-1);
        SortUtil.show(a);
    }

    //先递归 后归并
    public static void sort(Comparable[] a, int lo, int hi){
        if(lo>=hi)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a, lo,mid,hi);
    }

    //归并
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] temp = new Comparable[a.length];
        for(int k=lo;k<=hi;k++){
            temp[k] = a[k];
        }

        int i = lo;
        int j = mid+1;
        for(int k=lo;k<=hi;k++){
            if(i > mid)     a[k] = temp[j++];
            else if(j > hi) a[k] = temp[i++];
            else if(SortUtil.less(temp[i],temp[j])) a[k] = temp[i++];
            else   a[k] = temp[j++];
        }
    }
}
