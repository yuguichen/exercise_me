package 笔试.奇安信;


import java.util.*;

public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String PID = " ";
        String PPID = " ";
        int endId = 0;

        String[] p = PID.trim().split(" ");
        String[] pp = PPID.trim().split(" ");

        int[] pId = new int[p.length];
        int[] ppId = new int[pp.length];
        for(int i=0;i<pId.length;i++){
            pId[i] = Integer.parseInt(p[i]);
        }
        for(int i=0;i<ppId.length;i++){
            ppId[i] = Integer.parseInt(pp[i]);
        }

        int result = getEndIDNum(pId,ppId,endId);
        System.out.println(result);

    }

    public static  int getEndIDNum(int[] pId, int[] ppId,int endId){
        boolean has = false;
        Set<Integer> list = new TreeSet<>();
        for(int i=0;i<ppId.length;i++){
            if(endId == ppId[i]){
                has =true;
                list.add(endId);
                break;
            }
        }
        for(int i=0;i<pId.length;i++){
            if(endId == pId[i]){
                has =true;
                list.add(endId);
                break;
            }
        }

        if(!has)
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(endId);


        while(!stack.isEmpty()){
            int end_id = stack.pop();
            for(int i=0;i<ppId.length;i++){
                if(end_id == ppId[i]){
                    stack.push(pId[i]);
                    list.add(pId[i]);
                }
            }
        }

        return list.size();
    }


}
