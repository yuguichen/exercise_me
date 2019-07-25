package test;

import org.junit.Test;
import utils.InandOutUtils.In;
import 数据结构与算法.图.Graph;
import 数据结构与算法.查找.AVLTree;
import 数据结构与算法.查找.BinarySearchTree;
import 数据结构与算法.查找.RedBlackTree;

import java.io.File;
import java.util.*;

/**
 * 判断连续数字长度
 */
public class Test1 {
    public static void main(String[] args){
        //从控制台输入
        int[] a = getIn();

        ArrayList<int[]> arrayList = solution(a);

        for(int[] array:arrayList){
            System.out.println(array.length);
            for(int i = 0;i<array.length;i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }

    }

    public static int[] getIn(){
        //输入一串以空格为间隔的数字读取到字符串中，并转化为int[]数组
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[] numList = str.split("\\s");
        int[] a = new int[numList.length];
        for(int i = 0;i<a.length;i++){
            a[i] = Integer.parseInt(numList[i]);
        }
        return a;
    }

    public static ArrayList<int[]> solution(int[] a){
        ArrayList<int[]> arrayList = new ArrayList();
        String s = "";
        for(int i=0;i<a.length;i++){
            //最后一个元素
            if(i+1 == a.length){
                s+=a[i];
                String[] numList = s.split(",");
                int[] b = new int[numList.length];
                for(int j=0;j<b.length;j++){
                    b[j] = Integer.parseInt(numList[j]);
                }
                arrayList.add(b);
                break;
            }

            if(a[i]==a[i+1]-1){
                s+=(a[i]+",");
            } else{
                s+=a[i];
                String[] numList = s.split(",");
                int[] b = new int[numList.length];
                for(int j=0;j<b.length;j++){
                    b[j] = Integer.parseInt(numList[j]);
                }
                arrayList.add(b);
                s="";
            }
        }
        return arrayList;
    }

    @Test
    public void tesBST(){
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        Integer[] a = {18,19,7,14,5,2,2,13,12,9};
        Arrays.stream(a).forEach(System.out::println);

        System.out.println("--------");
        Arrays.stream(a).forEach((value)->bst.put(value,value));
        Object[] vals = bst.dlr();
        Arrays.stream(vals).forEach(System.out::println);
        System.out.println("--------");

        Object[] vals2 = bst.dlr2();
        for( Object node:vals2){
            System.out.print( node+",");
        }

        System.out.println("--------");
        Object[] vals3 = bst.ldr();
        for( Object val:vals3){
            System.out.print( val+",");
        }
    }

    @Test
    public void tesAVL(){
        AVLTree<Integer,Integer> avl = new AVLTree<>();
        Integer[] a = {18,19,7,14,5,2,2,13,12,9};
        Arrays.stream(a).forEach((value)->avl.put(value,value));
        System.out.println("--------");
    }

    @Test
    public void testRedBlackTree(){
        RedBlackTree<Character,Character> redBlackTree = new RedBlackTree<>();

        Character[] c = {'s','e','a','r','c','h','x','m','p','l'};
        for(int i=0;i<c.length;i++){
            redBlackTree.put(c[i],c[i]);
        }
        System.out.println("--------");

        redBlackTree.deleteMin();
        System.out.println("--------");

        redBlackTree.delete('m');
        System.out.println("--------");

        redBlackTree.delete('x');
        System.out.println("--------");

    }

    @Test
    public void testGraph(){
        // File file = new File("G:\\Java_WorkSpace\\exercise_me\\src\\test\\tinyG");
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("test/tinyG").getFile());
        Graph graph = new Graph(new In(file));
        System.out.println("--------");

    }

    @Test
    public void teatA(){
        C c = new C();
        A a1 = c.getE();
        System.out.println(a1.aaaa());
        A a2 = c.getF();
        System.out.println(a2.aaaa());
    }

}
