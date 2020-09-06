package 笔试.中兴;

import org.junit.Test;

public class 单词列表 {

    @Test
    public void test_rangeWordList(){
        String[] arr = {"nbcd","ghij","defg","kmn","jkln","dmn"};
        int result = rangeWordList(arr);
        System.out.println(result);
    }

    public int rangeWordList(String[] arr){
        int length = arr.length;
        boolean[] marked = new boolean[length];

        for(int i=0;i<length;i++){
            if(dfs(arr,marked,0,i))
                return 1;
        }

        return -1;
    }

    public boolean dfs(String[] arr, boolean[] marked, int depth, int index){
        if(depth == arr.length-1)
            return true;

        String s = arr[index];
        marked[index] = true;

        for(int i=0;i<arr.length;i++){
            if(marked[i])
                continue;

            if(s.charAt(s.length()-1)==arr[i].charAt(0)){
                if(dfs(arr,marked,depth+1,i))
                    return true;
            }
        }
        marked[index] = false;

        return false;
    }
}
