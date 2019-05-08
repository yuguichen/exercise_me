package 数据结构与算法.排序;

import 数据结构与算法.Utils.SortUtil;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args){
        Integer[] a = SortUtil.randn(1000000,20000);

        long start ;
        long  end ;
        SortUtil.show(a);
        start = System.currentTimeMillis();
        sort(a,0,a.length-1);
        end = System.currentTimeMillis();
        System.out.println("用时："+ (end-start));

    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo>=hi) return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        Comparable temp = a[lo];

        while(true){
            while(SortUtil.less(a[++i],temp)){
                if(i==hi)
                    break;
            }
            while(SortUtil.less(temp,a[--j])){
                if(j==lo)
                    break;
            }
            if(i>=j)
                break;
            SortUtil.exch(a,i,j);
        }
        SortUtil.exch(a,lo,j);
        return j;
    }
}
