package LeetCode;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3)
            return result;

        Arrays.sort(nums);
        quickSort(nums,0,nums.length-1);

        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0)
                return result;
            int L = i+1;
            int R = nums.length-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R && nums[L]==nums[L+1]) L++;
                    while(L<R && nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }
                if(sum>0) R--;
                if(sum<0) L++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1])
                i++;
        }

        return result;
    }

    public void quickSort(int[] arr, int lo, int hi){
        if(lo>=hi)
            return;

        int i = lo;
        int j = hi;
        int temp = arr[lo];

        while(i<j){
            while(i<j && temp<=arr[j])
                j--;
            if(i<j)
                arr[i++] = arr[j];
            while(i<j && temp>=arr[i])
                i++;
            if(i<j)
                arr[j--] = arr[i];
        }
        arr[i] = temp;
        quickSort(arr,lo,i-1);
        quickSort(arr,i+1,hi);

    }
}
