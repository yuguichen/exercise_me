package javaSE.集合;

import java.util.LinkedList;

/**
 * 使用LinkedList来模拟一个堆栈或队列数据结构
 * 堆栈：先进后出   DuiZhan
 * 队列：先进先出   DuiLie
 */
public class LinkedList_Demo {
    public static void main(String args[]){
       // DuiLie d=new DuiLie();
        DuiZhan d= new DuiZhan();
        d.myAdd("abc1");
        d.myAdd("abc2");
        d.myAdd("abc3");
        while(!d.isEmpty())
            System.out.println(d.myGet());
    }
}
//队列：先进先出   DuiLie
class DuiLie{
    private LinkedList link;

    public DuiLie(){
        link=new LinkedList();
    }

    public void myAdd(Object obj){
        link.addLast(obj);  //增
    }

    public Object myGet(){
        return link.removeFirst();
    }

    public  Boolean isEmpty(){
        return link.isEmpty();
    }
}

//堆栈：先进后出   DuiZhan
class DuiZhan{
    private LinkedList link;

    public DuiZhan(){
        link=new LinkedList();
    }

    public void myAdd(Object obj){
        link.addLast(obj);
    }

    public Object myGet(){
        return link.removeLast();
    }

    public  Boolean isEmpty(){
        return link.isEmpty();
    }
}