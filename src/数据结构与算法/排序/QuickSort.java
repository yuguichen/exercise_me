package 数据结构与算法.排序;

import 数据结构与算法.Utils.SortUtil;

/**
 * 快速排序
 *   时间复杂度 O(N*lgN)
 *   平均情况比最好情况要好 39%； 最好的情况是每次从中间切分
 *
 * 三向切分快速排序：
 *   对于具有大量重复元素的数组，可以将排序时间降低到线性级别
 *   荷兰国旗问题
 */
public class QuickSort {
    public static void main(String[] args){
        Integer[] a = SortUtil.randn(1000000,20000);

        long start ;
        long  end ;
        // SortUtil.show(a);
        start = System.currentTimeMillis();
        sort(a,0,a.length-1);
        end = System.currentTimeMillis();
        System.out.println("用时："+ (end-start));

        Integer[] b = SortUtil.randn(15,20);
        SortUtil.show(b);
        threeWayQuickSort(b,0,b.length-1);
        SortUtil.show(b);

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
                if(i==hi)  //注意边界值判断时，避免超出界限引起溢出或排序失败
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

    /**
     * 三向切分快速排序
     *      荷兰国旗问题
     */
    public static void threeWayQuickSort(Comparable[] a, int lo, int hi){
        if(hi<=lo)
            return; //递归的终止条件

        int lt = lo;
        int gt = hi;
        int i = lo+1;
        Comparable v = a[lo];

        while(i <= gt){
            int temp = a[i].compareTo(v);
            if(temp < 0)
                SortUtil.exch(a,lt++,i++);
            else if(temp > 0)
                SortUtil.exch(a,i,gt--); //交换后i不懂，因为右侧元素还未进行比较
            else
                i++;
        }

        threeWayQuickSort(a,lo,lt-1);
        threeWayQuickSort(a,gt+1,hi);
    }


    /**
     * 三向切分快速排序
     *  (对于基本数据类型)
     */
    public static void threeWayQuickSortOnChar(char[] a, int lo, int hi){
        if(hi<=lo)
            return; //递归的终止条件

        int lt = lo;
        int gt = hi;
        int i = lo+1;
        char v = a[lo];
        char temp;

        while(i <= gt){

            if(a[i] < v) {
                temp = a[lt];
                a[lt++] = a[i];
                a[i++] = temp;
            } else if(a[i] > v) {
                temp = a[i];
                a[i] = a[gt];
                a[gt--] = temp;
            }
            else
                i++;
        }

        threeWayQuickSortOnChar(a,lo,lt-1);
        threeWayQuickSortOnChar(a,gt+1,hi);
    }
}
