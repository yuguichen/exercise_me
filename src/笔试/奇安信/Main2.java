package 笔试.奇安信;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        in.nextLine();
        String s1 = in.nextLine().trim();

        String[] treeString = s1.split(" ");
        int[] tree = new int[treeString.length];
        for(int i=0;i<treeString.length;i++){
            tree[i] = Integer.parseInt(treeString[i]);
        }

        int child1  = in.nextInt();
        int child2 = in.nextInt();
        if(!(find(tree,child1) & find(tree,child2))){
            System.out.println(-1);
        } else{
            int i=0;
            int comParent = -1;
            while(i<tree.length){
                int parent = tree[i];
                if(child1>parent && child2>parent){
                    i=(i+1)*2;
                } else if(child1<parent && child2<parent){
                    i=(i+1)*2-1;
                } else if((child1<parent && child2>parent) || (child1>parent && child2<parent)){
                    comParent = parent;
                    break;
                } else if(child1 == parent || child2 == parent){
                    comParent = parent;
                    break;
                }
            }
            System.out.println(comParent);
        }
    }

    public static boolean find(int[] tree,int child){
        if(child == -1)
            return false;

        int i=0;
        while(i<tree.length){
            if(child == tree[i]){
                return true;
            } else if(child<tree[i]){
                i=(i+1)*2-1;
            } else if(child>tree[i]){
                i=(i+1)*2;
            }
        }
        return false;
    }


}
