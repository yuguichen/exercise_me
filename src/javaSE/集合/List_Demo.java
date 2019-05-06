package javaSE.集合;

import java.util.*;

/**
 * list接口常用的实现类有 ArrayList/LinkList/Vector
 */

public class List_Demo {
    public static void main(String args[]){
        List list =new ArrayList();

        list.add("abc1");
        list.add("abc2");
        list.add("abc3");

        /**
         * 这里要注意并发问题
         * 集合list和迭代器Iterator不能同时进行操作
         * 可采用接口Iterator的子接口ListIterator进行相应操作，避免出现并发异常。
         */
        for(ListIterator it =list.listIterator();it.hasNext();){
            Object obj=it.next();

            if(obj.equals("abc2")){
                it.set("abc9");
                //list.add("abc9");
                // java.util.ConcurrentModificationException异常
                System.out.println(obj);
            }
            else
                System.out.println(obj);
        }

        System.out.println(list);
    }
}
