package javaSE.多线程;

/**
 * 两种创建并启动线程的方式
 */
public class CreateThread {
    public static void main(String args[]){
        DemoThread demoThread  = new DemoThread("Thread");
        demoThread.start();

        DemoRunnable demoRunnable = new DemoRunnable("Runnable");
        new Thread(demoRunnable,"Runnable").start();
    }
}

class DemoThread extends Thread{
    private String name;
    DemoThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(getName()+"......方式一启动......");
        }
    }
}

class DemoRunnable implements Runnable{
    private String name;
    DemoRunnable(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"......方式二启动......");
        }
    }
}
