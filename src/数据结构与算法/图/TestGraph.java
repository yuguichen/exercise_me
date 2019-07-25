package 数据结构与算法.图;

import org.junit.Test;
import utils.InandOutUtils.In;
import utils.InandOutUtils.StdOut;

import java.io.File;

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
}
