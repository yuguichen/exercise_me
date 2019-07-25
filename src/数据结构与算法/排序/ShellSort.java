package 数据结构与算法.排序;

import utils.SortUtil;

/**
 * 希尔排序
 *      插入排序的变形，先将无序转变为局部有序，在经过排序变为有序
 *
 *  性能和步长相关
 */
public class ShellSort {
    public static void main(String[] args){
        //Integer[] a = SortUtil.randn(100000,1000);
        int[] a = new int[200000];
        for(int i=0;i<200000;i++){
            a[i] = (int)(Math.random() * 100000);
        }
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i] = a[i];
        }

        //插入排序
        System.out.println(SortUtil.isSorted_int(b,SortUtil.ASC));
        long start = System.currentTimeMillis();
        System.out.println("排序前："+start);
        InsertSort.sort1(b);
        long  end = System.currentTimeMillis();
        System.out.println("排序后："+end);
        System.out.println("用时："+ (end-start));
        System.out.println(SortUtil.isSorted_int(b,SortUtil.ASC));

        //希尔排序
        int[] sedgewick = sedgewick(a.length);

        System.out.println(SortUtil.isSorted_int(a,SortUtil.ASC));
        start = System.currentTimeMillis();
        System.out.println("排序前："+start);
        sort1(a,sedgewick);
        end = System.currentTimeMillis();
        System.out.println("排序后："+end);
        System.out.println("用时："+ (end-start));
        System.out.println(SortUtil.isSorted_int(a,SortUtil.ASC));

    }

    public static void sort(Comparable[] a,int[] sedgewick){
        int length = a.length;
        for(int k=sedgewick.length-1;k>=0;k--){
            int h = sedgewick[k];
            for(int i=h;i<length; i++){
                for( int j=i; j>=h; j-=h){
                    if(SortUtil.less(a[j],a[j-h])){
                        SortUtil.exch(a,j,j-h);
                    }
                }
            }
        }
    }

    public static void sort1(int[] a,int[] sedgewick){
        int length = a.length;
        int t = 0;
        for(int k=sedgewick.length-1;k>=0;k--){
            int h = sedgewick[k];
            for(int i=h;i<length; i++){
                for( int j=i; j>=h; j-=h){
                    if(a[j]<a[j-h]){
                        t = a[j];
                        a[j] = a[j-h];
                        a[j-h] = t;
                    }
                }
            }
        }
    }

    // 已知的最好步长序列是由Sedgewick提出的(1,5,19,41,109,...)
    // 塞奇威克(Sedgewick)步长序列函数,传入数组长度(最大分组个数不可超过数组长度)
    private static int[] sedgewick(int length) {
        // 不清楚步长的数组中的容量是多少
        // 但是如果使用容器还是需要转换的
        int[] arr = new int[length];
        int n;      //步长的总个数
        int i = 0;  // 控制奇数位步长的值
        int j = 0;  // 控制偶数位步长的值
        for (n = 0; n < length; n++) {
            // 偶数位上的值
            if (n % 2 == 0) {
                arr[n] = (int) (9 * (Math.pow(4, i) - Math.pow(2, i)) + 1);
                i++;
            } else {
                // 偶数位上的值
                arr[n] = (int) (Math.pow(2, j + 2) * (Math.pow(2, j + 2) - 3) + 1);
                j++;
            }
            // 步长的最大值已经大于数组总长
            // 跳出循环
            if (arr[n] >= length) {
                break;
            }
        }
        int[] a = new int[n];
        // 使用System.arraycopy复制数组
        // 仅仅复制有效步长，也就是n个有效的
        System.arraycopy(arr, 0, a, 0, n);
        return a;
    }
}
