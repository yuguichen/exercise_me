package 笔试.百度;

import java.util.*;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int val[] = new int[n];
        for(int i=0;i<n;i++){
            val[i] = in.nextInt();
        }

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int start = in.nextInt()-1;
            int end = in.nextInt()-1;
            if(!map.containsKey(start)){
                map.put(start,new ArrayList<>());
            }
            map.get(start).add(end);
        }

        int[] result = new int[n];
        boolean[] marked = new boolean[n];

        for(int i=0;i<n;i++){
            if(!marked[i]){
                dfs(map,i,result,marked,val);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(result[i]>ans)
                ans = result[i];
        }
        System.out.println(ans);
    }

    public static void dfs(Map<Integer,ArrayList<Integer>> map, int start,int[] result,boolean[] marked,int[] val){

        if(!map.containsKey(start)){
            result[start] = 1;
            marked[start] = true;
            return;
        } else {
            List<Integer> list = map.get(start);
            for(Integer i:list){
                if(!marked[i])
                    dfs(map,i,result,marked,val);

                if(val[start]<val[i])
                    result[start] = Math.max(result[start],result[i]+1);
                else
                    result[start] = Math.max(1,result[start]);
            }
            marked[start] = true;
        }


    }

}
