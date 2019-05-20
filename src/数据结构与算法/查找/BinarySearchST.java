package 数据结构与算法.查找;

/**
 * 基于有序数组的二分查找
 */
public class BinarySearchST<Key extends Comparable,Value> {

    private Key[] keys;
    private Value[] values;
    private int N;
    private int capacity;


    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        N = 0;
        this.capacity = capacity;
    }

    /**
     * 找到目标键值在数组中的位置
     * @param key
     * @return
     */
    public int rank(Key key){
        int lo = 0;
        int hi = N-1;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid-1;
            else if(cmp > 0) lo = mid +1;
            else return mid;
        }
        return lo;
    }

    /**
     * 插入元素
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        int rank = rank(key);
        //重复的键则覆盖
        if( rank<N && keys[rank].compareTo(key)==0){
            values[rank] = value;
            return;
        }
        if(N == capacity)
            resize();

        for(int i=N;i>rank;i--){
            keys[i] = keys[i-1];
            values[i] = values[i-1];
        }
        keys[rank] = key;
        values[rank] = value;
        N++;
    }

    /**
     * 动态调整空间大小，扩大1倍空间
     */
    public void resize(){
        capacity = 2*capacity;//将容量扩大一倍
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Object[capacity];
        for(int i = 0;i<N;i++){
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int rank = rank(key);
        if(rank<N && keys[rank].compareTo(key)==0)
            return values[rank];
        else
            return null;
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    public int getSize(){
        return N;
    }


    public static void main(String[] args){
        BinarySearchST<Character,Integer> bst = new BinarySearchST<>(20);
        bst.put('s',0); bst.put('e',1); bst.put('a',2);
        bst.put('r',3); bst.put('c',4); bst.put('h',5);
        bst.put('e',6); bst.put('x',7); bst.put('a',8);
        bst.put('m',9); bst.put('p',10); bst.put('l',11);
        bst.put('e',12);

        System.out.println(bst.isEmpty());

        System.out.println(bst.rank('s'));
        Integer a = bst.get('s');
        System.out.println(a);
    }

}
