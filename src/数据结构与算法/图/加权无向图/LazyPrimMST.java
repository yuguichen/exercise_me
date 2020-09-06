package 数据结构与算法.图.加权无向图;

import 数据结构与算法.bean.MinPQ;
import 数据结构与算法.bean.Queue;

import java.util.LinkedList;

/**
 * 延时prim算法计算最小生成树
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq; // 存储横切边

    public LazyPrimMST(EdgeWeightedGraph graph){
        marked = new boolean[graph.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();

        visit(graph, 0); // 初始化，访问第一个顶点
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue; // 不是横切边

            mst.enqueue(e);

            if(!marked[v])
                visit(graph, v);
            if(!marked[w])
                visit(graph, w);
        }
    }

    // 将横切边插入到队列中
    private void visit(EdgeWeightedGraph graph, int v){
        marked[v] = true;
        for(Edge e:graph.adj(v)){
            if(!marked[e.other(v)])
                pq.insert(e);
        }
    }

    public Queue<Edge> mst(){
        return mst;
    }
}
