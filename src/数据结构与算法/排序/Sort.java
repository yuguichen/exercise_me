package 数据结构与算法.排序;

import java.util.Arrays;

/**
 * 各种排序
 */
public class Sort {
    public static void main(String[] args){
        int[] a = {5,4,9,8,7,6,0,1,3,2};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 堆排序
     * 1 构造大顶堆
     * 2 排序
     */
    public static void heapSort(int[] arr){
        int len = arr.length-1;
        for(int i=len/2;i>=0;i--)
            sink(arr, i, len);
        System.out.println(Arrays.toString(arr));
        while(len>=0){
            swap(arr,0,len--);
            sink(arr,0,len);
        }
    }

    private static void sink(int[] a, int i, int len){
        while(i*2+1 <= len){
            int k = i*2+1;
            if(k<len && a[k]<a[k+1])
                k++;
            if(a[i]<a[k])
                swap(a,i,k);
            i = k;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }
    private static void quick(int[] arr, int lo, int hi){
        if(lo>hi)
            return;
        int i = lo;
        int j = hi;
        int temp = arr[lo];

        while(i<j){
            while(i<j && arr[j]>=temp)
                j--;
            if(i<j)
                arr[i++] = arr[j];

            while(i<j && arr[i]<=temp)
                i++;
            if(i<j)
                arr[j--] = arr[i];
        }
        arr[i] = temp;
        quick(arr,lo,i-1);
        quick(arr,i+1,hi);

    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        int length = arr.length;
        int j;
        for(int h=length/2; h>0;h=h/2){
            for(int i=h; i<length;i++){
                int temp = arr[i];
                for(j = i-h; j>=0; j-=h){
                    if(temp <arr[j])
                        arr[j+h] = arr[j];
                    else
                        break;
                }
                arr[j+h] =temp;
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        int length = arr.length;

        for(int i=0;i<length;i++){
            int temp  = arr[i];
            int flag = i;
            for(int j=i+1;j<length;j++){
                if(temp>arr[j]){
                    temp = arr[j];
                    flag = j;
                }
            }
            if(flag != i)
                swap(arr, flag, i);
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        int length = arr.length;
        for(int i=1; i<length; i++){
            int temp = arr[i];
            int j = i;
            while (j>=1 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void maoPao(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            for(int j=len-1; j>i; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }


    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
