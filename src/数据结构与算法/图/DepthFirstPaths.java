package 数据结构与算法.图;

import java.util.Stack;

/**
 * 深度优先遍历查找路径
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph,s);
    }

    /**
     * 深度优先遍历
     */
    private void dfs(Graph graph,int v){
        marked[v] = true;
        for(int w:graph.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(graph,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for(int x=v; x!=s; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
