package javaSE.集合;

import javaSE.src2.Person;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet集合
 * 无序存储
 * 数据结构是哈希表
 * 通过hashcode方法确定元素位置，在通过equals方法判断内容是否相同
 *
 * 存储自定义类型时，若保证元素不重复，则必须重写equals方法
 * 因为list和set集合都要判断equals方法
 */

public class HashSet_Demo {
    public static void main(String args[]){
        HashSet hs =new HashSet();

        hs.add(new Person("li",11));
        hs.add(new Person("wang",11));
        hs.add(new Person("yu",21));
        hs.add(new Person("mao",13));
        hs.add(new Person("wang",11));

        //System.out.println(hs);
        Iterator it = hs.iterator();
        while(it.hasNext()){
            Person p = (Person) it.next();//迭代器返回为Object类型，需要向下转型成Person类型
            System.out.println(p.getName()+"-------"+p.getAge());
        }
    }
}

