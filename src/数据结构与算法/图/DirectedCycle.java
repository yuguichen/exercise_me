package 数据结构与算法.图;

import java.util.Stack;

/**
 * 寻找有向环
 */
public class DirectedCycle {
    private int[] edgeTo;
    private boolean[] marked;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph digraph){
        int V = digraph.V();
        edgeTo = new int[V];
        marked = new boolean[V];
        onStack = new boolean[V];

        for(int i=0; i<V; i++){
            if(!marked[i])
                dfs(digraph,i);
        }
    }

    /**
     * 只能找到一个有向环，即返回结果
     * @param digraph
     * @param s
     */
    private void dfs(Digraph digraph, int s){
        marked[s] = true;
        onStack[s] = true;

        for(int w:digraph.adj(s)){
            if(this.hasCycle())
                return;
            else if(!marked[w]){
                edgeTo[w] = s;
                dfs(digraph, w);
            } else if(onStack[w]){
                cycle = new Stack<>();
                for(int i=s; i!=w; i=edgeTo[i]){
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(s);
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
