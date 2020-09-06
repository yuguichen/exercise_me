package 数据结构与算法.图;

import 数据结构与算法.bean.Queue;

import java.util.Stack;

/**
 * 基于深度优先遍历的顶点排序：前序、后序、逆后序
 *
 * 并利用逆后序实现拓补排序方法（topological）
 *
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; // 前序
    private Queue<Integer> post; // 后序
    private Stack<Integer> reversePost; // 逆后序

    public DepthFirstOrder(Digraph digraph){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.V()];

        for(int v=0; v<digraph.V(); v++){
            if(!marked[v])
                dfs(digraph, v);
        }
    }

    private void dfs(Digraph digraph, int v){
        pre.enqueue(v);

        marked[v] = true;
        for(int w:digraph.adj(v)){
            if(!marked[w])
                dfs(digraph, w);
        }

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Stack<Integer> reversePost(){
        return reversePost;
    }

    /**
     * 拓补排序
     * @param digraph
     * @return
     */
    public Iterable<Integer> topological(Digraph digraph){
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if(!directedCycle.hasCycle()){
            return reversePost();
        } else
            return null;
    }
}

