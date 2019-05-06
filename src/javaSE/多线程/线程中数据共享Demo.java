package javaSE.多线程;

public class 线程中数据共享Demo {
    public static void main(String args[]){
        goxiang();
        //noGoXiang();
    }

    public static void noGoXiang(){
        MyThread A = new MyThread("A");
        MyThread B = new MyThread("B");
        MyThread C = new MyThread("C");
        A.start();
        B.start();
        C.start();
    }

    public static void goxiang(){
        MyThread myThread = new MyThread();

        // Thread类中定义了将Runnable接口以参数形式传递的构造函数
        //而且Thread类也实现了Runnable接口
        //因此可以将Thread类的对象传递给Thread类的构造函数

        Thread A = new Thread(myThread,"A");
        Thread B = new Thread(myThread,"B");
        Thread C = new Thread(myThread,"C");
        Thread D = new Thread(myThread,"D");
        A.start();
        B.start();
        C.start();
        D.start();

    }
}

class MyThread extends Thread{

    private int count = 20000;

    public MyThread(){
        super();
    }

    public MyThread(String name){
        //super();
        this.setName(name);
    }

     public void run(){
        super.run();
        while(count>0){
            synchronized (this){
                if(count>0){
                    count--;
                    System.out.println(this.currentThread().getName() + "计算，count=" + count);
                }
            }
        }
    }

}
