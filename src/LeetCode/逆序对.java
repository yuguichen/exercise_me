package LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class 逆序对 {
    @Test
    public void testInversePairs(){
        //int[] nums = {7,5,6,4};
        int[] nums = {8,5,6,2,1,4,7,9};
        System.out.println(inversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int inversePairs(int[] nums){
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            copy[i] = nums[i];
        int count = inversePairsSolution(nums,copy,0,nums.length-1);
        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(copy));
        //nums = copy;//无效，值传递
        for(int i=0;i<nums.length;i++)
            nums[i] = copy[i];
        return count;
    }

    public int inversePairsSolution(int[] nums, int[] copy, int start, int end){
        if(end==start){
            copy[start] = nums[start];
            return 0;
        }

        int count = 0;
        int length = (end-start+1)/2;

        int left = inversePairsSolution(copy,nums,start,start+length-1);
        int right = inversePairsSolution(copy,nums,start+length,end);

        int i = start+length-1;
        int j = end;
        int index = end;
        while(i>=start && j>=start+length){
            if(nums[i]>nums[j]){
                count += j-start-length+1;
                copy[index--] = nums[i--];
            } else{
                copy[index--] = nums[j--];
            }
        }
        for(;i>=start;i--)
            copy[index--] = nums[i];
        for(;j>=start+length;j--)
            copy[index--] = nums[j];

        return count+left+right;
    }
}
