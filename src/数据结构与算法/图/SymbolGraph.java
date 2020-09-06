package 数据结构与算法.图;

import utils.InandOutUtils.In;
import 数据结构与算法.bean.ST;

/**
 * 符号图-数据结构
 *      实际中，图的顶点是由字符串定义
 */
public class SymbolGraph {
    private ST<String,Integer> st; // string：顶点名；int：索引
    private String[] keys; // 反向索引
    private Graph graph; // 使用索引引用图中的顶点

    /**
     * 构造函数：构造符号图
     * @param filename 文件名称
     * @param sp  顶点间分隔符
     */
    public SymbolGraph(String filename, String sp){
        st = new ST<>();
        In in = new In(filename);
        // 第一遍读取文件
        while (in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            for(int i=0; i<a.length; i++){
                if(!st.contains(a[i]))
                    st.put(a[i],st.size());
            }
        }
        // 初始化反向索引
        int size = st.size();
        keys = new String[size];
        for(String name:st.keys()){
            keys[st.get(name)] = name;
        }
        // 第二遍遍历构造以索引为顶点的图
        graph = new Graph(size);
        in = new In(filename);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for(int i=1; i<a.length; i++){
                graph.addEdge(v, st.get(a[i]));
            }
        }
    }

    public int index(String name){
        return st.get(name);
    }

    public String name(int index){
        return keys[index];
    }

    public Graph G(){
        return graph;
    }



}
