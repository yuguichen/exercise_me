package javaSE.多线程;

import java.util.concurrent.atomic.AtomicLong;

public class Demo {
    private final AtomicLong count = new AtomicLong(0);

    public static void main(String args[]){

    }
}

class A{
    A(){
        System.out.println("aaaaaaa");
    }

    public void doSomething() {
        System.out.println("A doSomeThing.......");
    }
}

class B extends A{
    B(){
        System.out.println("BBBBBBBBBB");
    }

    public void doSomething() {
        System.out.println("B doSomeThing.......");
        super.doSomething();
    }
}
