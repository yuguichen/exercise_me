package 数据结构与算法.Utils;

import org.junit.Test;

import java.util.function.Supplier;

public class SortUtil {

    public static final String DESC = "desc";
    public static final String ASC = "asc";

    /**
     * 比较v,w
     *   若 v<w 返回true；否则返回 false
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    /**
     * 交换两个元素位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 是否有序
     * order :     public static final String DESC = "desc";
     *         或  public static final String ASC = "asc";
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a,String order){
        if(order.equals("asc")) {
            for(int i=1;i<a.length;i++)
                if(less(a[i],a[i-1]))
                    return false;
        } else if(order.equals("desc")) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i-1], a[i]))
                    return false;
        }
        return true;
    }

    public static boolean isSorted_int(int[] a,String order){
        if(order.equals("asc")) {
            for(int i=1;i<a.length;i++)
                if(a[i]<a[i-1])
                    return false;
        } else if(order.equals("desc")) {
            for (int i = 1; i < a.length; i++)
                if (a[i-1]<a[i])
                    return false;
        }
        return true;
    }
    /**
     * 打印所有元素
     * @param a
     */
    public static void show(Comparable[] a){
        System.out.println("a[i]: {");
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.print(" }");
        System.out.println();
    }

    // 随机产生长度为length的 0~max 的整形数组
    public static Integer[] randn(int length,int max){
        Integer[] a = new Integer[length];
        for(int i=0;i<length;i++){
            a[i] = (int)(Math.random() * max);
        }
        return a;
    }



    public static Integer[] getArray(int length, Supplier<Integer> sup){
        Integer[] t  = new Integer[length];
        for(int index=0;index<length;index++){
            t[index] = sup.get();
        }
        return t;
    }

    @Test
    public void test(){
        Integer[] a = getArray(20,() -> (int)(Math.random() * 100));
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
