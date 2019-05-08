package 数据结构与算法.排序;

import 数据结构与算法.Utils.SortUtil;

/**
 * 归并排序
 *  时间复杂度 O(N*lgN)
 *  空间复杂度 O（N） 需要复制数组
 *  访问数组的最多次数为 6N*lgN 次
 */
public class MergeSort {
    public static void main(String[] args){

        Integer[] a = SortUtil.randn(5,100);
        SortUtil.show(a);
        //topToBottomSort(a,0,a.length-1);
        bottomToTopSort(a);
        SortUtil.show(a);
    }

    //自底向上归并
    public static void bottomToTopSort(Comparable[] a){
        int length = a.length;

        for(int size=1;size<length;size=size+size){
            for(int lo=0;lo<length-size;lo+=(size+size)){
                merge(a,lo,lo+size-1,Math.min(lo+size+size-1,length-1));
            }
        }


    }

    //自顶向下归并：先递归 后归并
    public static void topToBottomSort(Comparable[] a, int lo, int hi){
        if(lo>=hi)
            return;
        int mid = lo + (hi-lo)/2;
        topToBottomSort(a,lo,mid);
        topToBottomSort(a,mid+1,hi);

        if(SortUtil.less(a[mid],a[mid+1])){
            //两部分已经有序，当左侧最大 < 右侧最小 可以跳过归并
            return;
        }
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
