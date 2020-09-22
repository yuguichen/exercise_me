package 数据结构与算法.图;

import utils.InandOutUtils.In;

/**
 * 有向图
 */
public class Digraph {
    private Bag<Integer>[] adj;
    private int E;       // 边
    private final int V; //顶点个数


    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<>();
        }
    }

    public Digraph(In in){
        this(in.readInt());
        this.E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            adj[v].add(w);
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 有向图取反
     * @return
     */
    public Digraph reverse(){
        Digraph re_graph = new Digraph(V);
        for(int i=0; i<V; i++){
            for(int w:adj[i]){
                re_graph.addEdge(w,i);
            }
        }
        return re_graph;
    }
}
