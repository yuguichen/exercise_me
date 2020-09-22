package 数据结构与算法.图.加权无向图;

import 数据结构与算法.bean.IndexMinPQ;
import 数据结构与算法.图.Graph;

/**
 * 即时版Prim算法计算最小生成树
 */
public class PrimMST {
    private boolean[] marked;
    private double[] distTo;
    private Edge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph graph){
        int V = graph.V();
        marked = new boolean[V];
        distTo = new double[V];
        edgeTo = new Edge[V];
        pq = new IndexMinPQ<>(V);
        for(int i=0; i<V; i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0,0.0);
        while (!pq.isEmpty())
            visit(graph, pq.delMin());

    }

    private void visit(EdgeWeightedGraph graph, int v){
        marked[v] = true;
        for(Edge e:graph.adj(v)){
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight()<distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();

                // 更新横切边，保证队列中横切边权重最小
                if(pq.contains(w))
                    pq.changeKey(w,distTo[w]);
                else
                    pq.insert(w,distTo[w]);
            }
        }
    }
}
