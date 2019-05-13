package 数据结构与算法.排序;

/**
 * 优先队列（基于二叉堆实现：堆有序的完全二叉树）
 *    1 插入元素；
 *    2 删除最大元素；
 *
 * @param <Key>
 */
public class MaxPQ< Key extends Comparable<Key> > {
    private Key[] pq; // pq[0] 不存储元素
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public MaxPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Comparable[keys.length + 1];
        for (int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for (int k = N/2; k >= 1; k--)
            sink(k);
    }

    /**
     * 插入元素
     * @param v
     */
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    /**
     * 删除最大元素
     * @return
     */
    public Key deleteMax(){
        if(N==0)
            return null;
        Key max = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;
        sink(1);
        return max;
    }

    /**
     * 下沉操作
     */
    private void sink(int index){
        while(2*index <= N){
            int k = 2*index;
            if(k<N && less(k,k+1)) k++;
            if(!less(index,k)) break;
            exch(index,k);
            index = k;
        }
    }

    /**
     * 上浮操作
     * @param index
     */
    private void swim(int index){
        while(index>1 && less(index/2, index) ){
            exch(index/2,index);
            index = index/2;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}
