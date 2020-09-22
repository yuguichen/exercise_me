package 数据结构与算法.图;

import utils.InandOutUtils.In;

/**
 * 图
 */
public class Graph {
    private final int V; //顶点个数
    private int E;       // 边
    private Bag<Integer>[] adj;//邻接数组

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for(int i=0;i<V;i++)
            adj[i] = new Bag<>();
    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    /**
     * 增加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }
}
