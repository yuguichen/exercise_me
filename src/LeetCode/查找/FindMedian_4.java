package LeetCode.查找;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O( log(m+n) )。
 */
public class FindMedian_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 判断数组是否为空
        if(nums1 == null){
            int n = nums2.length;
            if(n%2==1)
                return nums2[n/2];
            else
                return (nums2[n/2-1]+nums2[n/2])/2.0;
        }
        if(nums2 == null){
            int m = nums1.length;
            if(m%2==1)
                return nums1[m/2];
            else
                return (nums1[m/2-1]+nums1[m/2])/2;
        }

        int m = nums1.length; // 第一个数组长度
        int n = nums2.length; // 第二个数组长度

        // 保证 m<= n, j>=0
        if(m>n){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tem = m; m = n; n = tem;
        }

        int iMin = 0;
        int iMax = m;
        int halfLength = (m+n+1)/2;

        while(iMin <= iMax){
            int i = (iMin+iMax)/2;
            int j = halfLength -i;

            if( i>iMin && nums1[i-1]>nums2[j] ){
                iMax = i-1;
            } else if( i<iMax && nums2[j-1]>nums1[i] ){
                iMin = i+1;
            } else {
                int maxLeft = 0;
                if( i==0 )      maxLeft = nums2[j-1];
                else if( j==0 ) maxLeft = nums1[i-1];
                else            maxLeft = Math.max(nums2[j-1],nums1[i-1]);
                if( (m+n)%2 == 1 )
                    return maxLeft;

                int minRight = 0;
                if( i==m )      minRight = nums2[j];
                else if( j==n ) minRight = nums1[i];
                else            minRight = Math.min(nums1[i],nums2[j]);
                return  (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
