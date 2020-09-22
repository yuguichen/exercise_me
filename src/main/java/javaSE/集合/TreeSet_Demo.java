package javaSE.集合;

import javaSE.src2.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_Demo {
    public static void main(String args[]) {
        UpdateStu stu1 = new UpdateStu("li", 01011);
        UpdateStu stu2 = new UpdateStu("chen", 01031);
        UpdateStu stu3 = new UpdateStu("wang", 01051);
        UpdateStu stu4 = new UpdateStu("na", 01011);

        TreeSet<UpdateStu> tree = new TreeSet<>();
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);

        Iterator<UpdateStu> it = tree.iterator();

        System.out.println("set集合中所有元素");
        while (it.hasNext()) {
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getName() + "........." + stu.getId());
        }

        it = tree.headSet(stu2).iterator();
        System.out.println("set集合中stu2前面的元素");
        while (it.hasNext()) {
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getName() + "........." + stu.getId());
        }

        it = tree.subSet(stu2, stu3).iterator();
        System.out.println("set集合中stu2,stu3之间的元素");
        while (it.hasNext()) {
            UpdateStu stu = (UpdateStu) it.next();
            System.out.println(stu.getName() + "........." + stu.getId());


        }
    }
}

/**
 * 1，让元素自身具备排序功能 comparaTo
 * 2，让集合具备比较功能
 *      定义一个类实现comparator接口，重写compara方法，并将其对象最为构造参数传给集合
 */

class UpdateStu implements Comparable<Object>{

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    String name;
    long id;

    public UpdateStu(String name,long id){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Object o) {
        //return 0;
        //if(o instanceof UpdateStu)
            UpdateStu upstu = (UpdateStu) o;

        int result=id>upstu.id? 1:(id==upstu.id?0:-1);
        return result==0?this.name.compareTo(upstu.name):result;
    }
}

class Comparaby implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return 0;
    }
}


