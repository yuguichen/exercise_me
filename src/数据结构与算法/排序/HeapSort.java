package 数据结构与算法.排序;

import 数据结构与算法.Utils.SortUtil;

/**
 * 堆排序
 *   比较次数 < {2*N*lg(N) + 2*N}
 *   其中 构造堆 2*N
 *        排序  2*N*lg(N)
 */
public class HeapSort {
    public static void main(String[] args){
        Integer[] a = SortUtil.randn(10,100);
        a[0] = 0;
        SortUtil.show(a);
        //topToBottomSort(a,0,a.length-1);
        sort(a);
        SortUtil.show(a);
    }

    public static void sort(Comparable[] a){
        int N = a.length-1;
        //构造二叉堆
        for(int i=N/2;i>0;i--){
            sink(a,i,N);
        }
        //排序
        while(N>1){
            SortUtil.exch(a,1,N--);
            sink(a,1,N);
        }
    }

    public static void swim(Comparable[] a, int i){
        while(i/2 >= 1){
            if( SortUtil.less(a[i],a[i/2]) )
                break;

            SortUtil.exch(a,i,i/2);
            i = i/2;
        }
    }

    public static void sink(Comparable[] a, int i, int num){
        //int N = a.length-1;
        while(2*i <= num){
            int k = 2*i;
            if( k<num && SortUtil.less(a[k],a[k+1]))
                k++;
            if(SortUtil.less(a[i],a[k]))
                SortUtil.exch(a,i,k);
            i = k;
        }
    }
}
