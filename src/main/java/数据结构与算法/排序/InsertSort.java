package 数据结构与算法.排序;

import utils.SortUtil;

/**
 * 插入排序
 *      最坏的情况 比较 N^2/2, 交换 N^2/2；（逆序排列）
 *      最好的情况 比较 N-1,   交换 0 （有序排列）
 *      平均情况   比较 N^2/4, 交换N^2/2
 * 适合小规模或局部有序的数据排序
 */
public class InsertSort {
    public static void main(String[] args){
        Integer[] a = SortUtil.randn(20000,1000000);
        Integer[] b = new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i] = a[i];
        }
        //SortUtil.show(a);
        System.out.println(SortUtil.isSorted(a,SortUtil.ASC));
        long start = System.currentTimeMillis();
        System.out.println("排序前："+start);
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println("排序后："+end);
        System.out.println("用时："+ (end-start));
        System.out.println(SortUtil.isSorted(a,SortUtil.ASC));

        System.out.println(SortUtil.isSorted(b,SortUtil.ASC));
        start = System.currentTimeMillis();
        System.out.println("排序前："+start);
        sortP(b);
        end = System.currentTimeMillis();
        System.out.println("排序后："+end);
        System.out.println("用时："+ (end-start));
        System.out.println(SortUtil.isSorted(b,SortUtil.ASC));


    }

    //升序排列
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(SortUtil.less(a[j],a[j-1]))
                    SortUtil.exch(a,j,j-1);
            }
        }
    }

    public static void sort1(int[] a){
        int t =0;
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    t=a[j];
                    a[j]=a[j-1];
                    a[j-1]=t;
                }
            }
        }
    }

    //改进： 将较大的元素统一向后移
    public static void sortP(Comparable[] a){
        int i ,j,k;
        for(i=1;i<a.length;i++){
            Comparable temp = a[i];
            for(j=i-1;j>=0;j--){
                if(!SortUtil.less(a[i],a[j]))
                    break;
            }

            for(k=i-1;k>j;k--){
                a[k+1] = a[k];
            }
            a[k+1] = temp;
        }
    }
}