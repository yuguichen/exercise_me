package 数据结构与算法.图;

import org.junit.Test;
import utils.InandOutUtils.In;
import utils.InandOutUtils.StdOut;

import java.io.File;
import java.util.Stack;

public class TestGraph {

    @Test
    public void testDFS(){
        String path = "test/tinyG";
        File file = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
        Graph graph = new Graph(new In(file));

        DepthFirstPaths dfs = new DepthFirstPaths(graph,5);
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", 5, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == 5) StdOut.print(x);
                    else        StdOut.print( x + "-");
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d:  not connected\n", 5, v);
            }

        }
    }

    @Test
    public void testDigraph(){
        String path = "test/tinyG";
        File file = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
        Digraph digraph = new Digraph(new In(file));

        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if(directedCycle.hasCycle()){
            Stack<Integer> stack = (Stack<Integer>)directedCycle.cycle();
            while(!stack.empty()){
                System.out.print(stack.pop()+"-");
            }
            System.out.print("end");
        }

    }

    @Test
    public void testStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(3);


        for(int w:stack){
            System.out.print(w+"-");
        }
        System.out.println("end");

        while(!stack.empty()){
            System.out.print(stack.pop()+"-");
        }
    }

    @Test
    public void testSCC(){
        String path = "test/tinyG";
        File file = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
        Digraph digraph = new Digraph(new In(file));

        KosarajuSCC kosarajuSCC = new KosarajuSCC(digraph);
        int count = kosarajuSCC.getCount();
        int[] id = kosarajuSCC.getId();
        System.out.println(count+"componments");
        System.out.println();
        for(int i=0; i<count; i++){
            System.out.print(i+":");
            for(int j=0; j<digraph.V();j++){
                if(id[j]==i)
                    System.out.print(j+",");
            }
            System.out.println();
        }
    }
}
