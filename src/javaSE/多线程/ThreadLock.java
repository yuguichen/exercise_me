package javaSE.多线程;

public class ThreadLock {
    public static void main(String args[]){
        final ThreadLock test = new ThreadLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test.method2();
                test.method3();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        test.method1();
    }

    public synchronized void method1(){
        try {
            Thread.sleep(1000);
            System.out.println("call method1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2(){
        System.out.println("call method2" );
    }

    public synchronized  void method3(){
        System.out.println("call method3" );
    }






}
