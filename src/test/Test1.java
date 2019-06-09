package test;

import org.junit.Test;
import 数据结构与算法.Utils.SortUtil;
import 数据结构与算法.查找.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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


}
