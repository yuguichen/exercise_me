package LeetCode.排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 58.合并重叠区间
 *
 * 示例 1:
 *      输入: [[1,3],[2,6],[8,10],[15,18]]
 *      输出: [[1,6],[8,10],[15,18]]
 *      解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *      输入: [[1,4],[4,5]]
 *      输出: [[1,5]]
 *      解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *      方案1：先排序，在合并
 *          三向切分快速排序
 *          优于 Arrays.sort(intervals, new Comparator<int[]>(){}
 *          优于流操作Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
 *      方案2：有人用图的思想来做
 *
 *
 */
public class MergeIntervals_58 {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for(int i=0;i<intervals.length;i++){
            System.out.println(intervals[i][0] +"-"+intervals[i][1]);
        }

        int[][] a = merge(intervals);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i][0] +"-"+a[i][1]);
        }
    }

    /**
     * 先排序，在合并
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals){
        int length = intervals.length;
        int N = length;
        if(length<=1)
            return intervals;

        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));//升序排序
        // 这里的流操作速度慢，LeetCode提交流操作 80ms，下面方式20ms以内
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });//升序排序


        sort(intervals,0,length-1);

        for(int i=1,j=0;i<length;i++){
            if(intervals[j][1] >= intervals[i][0]){
                if(intervals[j][1]<intervals[i][1])
                    intervals[j][1] = intervals[i][1];
                //intervals[j][1] = intervals[j][1]>intervals[i][1]? intervals[j][1]:intervals[i][1];
                intervals[i] = null;
                N--;
            } else {
                j = i;
            }
        }

        int[][] a = new int[N][2];
        for(int j=0,i=0;j<length;j++){
            if(intervals[j] != null){
                a[i] = intervals[j];
                i++;
            }
        }
        return a;
    }

    //复习一下排序算法(三向切分快速排序)
    public static void sort(int[][] a, int lo, int hi){

        if(hi<=lo)
            return; //递归的终止条件

        int v = a[lo][0];
        int lt = lo;
        int gt = hi;
        int i = lo+1;

        while(i<=gt){
            if(a[i][0] < v){
                int[] temp = a[i]; a[i] = a[lt]; a[lt] = temp;
                i++;
                lt++;
            } else if(a[i][0] > v){
                int[] temp = a[i]; a[i] = a[gt]; a[gt] = temp;
                gt--;
            } else {
                i++;
            }
        }

        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }



}
