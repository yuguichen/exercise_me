package javaSE.多线程;

public class ThreadLock {
    public static void main(String args[]){
        final ThreadLock test = new ThreadLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    test.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
            System.out.println("call method1"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("call method2" +Thread.currentThread().getName());
    }

    public synchronized  void method3(){
        System.out.println("call method3" +Thread.currentThread().getName());
    }






}
