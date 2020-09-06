package 数据结构与算法.图;


import 数据结构与算法.bean.Queue;

import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.s = s;
        bfs(graph,s);
    }

    /**
     * 广度优先遍历
     */
    private void bfs(Graph graph,int v){
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(v);
        marked[v] = true;
        while(!queue.isEmpty()){
            int w = queue.dequeue();
            for(int x:graph.adj(w)){
                if(!marked[x]){
                    queue.enqueue(x);
                    marked[x] = true;
                    edgeTo[x] = w;
                }
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
