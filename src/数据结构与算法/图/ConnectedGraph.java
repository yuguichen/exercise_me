package 数据结构与算法.图;

/**
 * 判断是否存在连通图
 */
public class ConnectedGraph {

    private boolean[] marked;
    private int[] id; // 连通标志位
    private int count = 0;

    public ConnectedGraph(Graph graph){
        int v = graph.V();
        marked = new boolean[v];
        id = new int[v];
        for(int s=0; s<v; s++){
            if(!marked[s]){
                dfs(graph,s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int s){
        marked[s] = true;
        id[s] = count;
        for(int v:graph.adj(s)){
            if(!marked[v])
                dfs(graph, v);
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int v, int w){
        return id[v]==id[w];
    }
}
