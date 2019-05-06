package javaSE.集合;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合学习
 * 用于存储对象
 * 长度可变
 * 集合中不可以存储基本数据类型值
 * 常用方法：add(obj); addAll(collection); remove(obj);removeAll(coll); clear(); contains(obj);containsAll(coll);
 *           retainAll(coll);//取交集     size（）；
 *           Iterator();//迭代器，取出集合元素的方式，
 *                        容器类中的内部类实现的
 * 常用的容器ArrayList、
 */
public class Collection_Demo {
    public static void main (String args[]){

        ArrayList coll=new ArrayList();
        show2(coll);

    }

    //Practice the use of iterator()
    public static void show2(Collection coll){
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");

        Iterator it=coll.iterator();//调用集合中迭代器方法是为了获得集合中迭代器对象

        while(it.hasNext()){
            System.out.println(it.next());
        }

        /**
         * 实际开发中常用这种写法
         * 当for循环结束后it消失，不占用空间
         */
        for(Iterator It= coll.iterator();It.hasNext();){
            System.out.println(It.next());
        }
    }

    public static void show(Collection coll){

        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        System.out.println(coll);

        Boolean b1=coll.contains("abc2");
        System.out.println(b1);

        coll.remove("abc2");
        b1=coll.contains("abc2");
        System.out.println(b1);
        //coll.clear();
        //coll.removeAll(coll);
        System.out.println(coll);
    }
}
