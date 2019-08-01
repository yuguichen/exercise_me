package 数据结构与算法.图;

import java.util.Stack;

/**
 * 计算有向图中强连通分量
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id; // 保存顶点对应的连通分量id
    private int count = 0; // 连通分量数目

    /*
        1、计算反向图的逆后序排列；
        2、按照逆后序对图进行DFS；（在同一DFS中的顶点为强连通分量）
     */
    public KosarajuSCC(Digraph digraph){
        int V = digraph.V();
        marked = new boolean[V];
        id = new int[V];

        Digraph reDigraph = digraph.reverse();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(reDigraph);
        Stack<Integer> order = depthFirstOrder.reversePost();
        while(!order.empty()){
            int v = order.pop();
            if(!marked[v]){
                dfs(digraph,v);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v){
        marked[v] = true;
        id[v] = count;
        for(int w:digraph.adj(v)){
            if(!marked[w])
                dfs(digraph,w);
        }
    }

    public boolean isSCC(int w, int v){
        return id[w]==id[v];
    }

    public int[] getId(){
        return id;
    }
    public int getCount(){
        return count;
    }
}
