package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总数 {

    @Test
    public void testcombinationSum2(){
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> result = combinationSum2(candidates,8);

        System.out.print(result.toString());
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        recursion(result,new ArrayList<>(),candidates,target,0);

        return result;
    }

    /**
     * 递归
     */
    public void recursion(List<List<Integer>> result,List<Integer> list,int[] candidates,int target,int index){
        if(target<0)
            return;

        // 注意构造新的list
        if(target == 0)
            result.add(new ArrayList<>(list));
        else{
            for(int i=index;i<candidates.length;i++){
                if(i>index && candidates[i]==candidates[i-1])
                    continue;

                list.add(candidates[i]);
                recursion(result,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }

    }
}
