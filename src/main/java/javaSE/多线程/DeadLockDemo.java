package javaSE.多线程;

/**
 * 死锁实例
 */
public class DeadLockDemo {
    public static void main(String args[]){
        Test test1 = new Test(true);
        Test test2 = new Test(false);

        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);

        thread1.start();
        thread2.start();

    }
}

class Test implements Runnable{
    private boolean flag;
    Test(boolean flag){ this.flag = flag; }

    @Override
    public void run() {
        if(flag){
            synchronized(MyLock.locka){
                System.out.println("if......locka");
                synchronized(MyLock.lockb){
                    System.out.println("if......lockb");
                }
            }
        } else{
            synchronized(MyLock.lockb){
                System.out.println("else......lockb");
                synchronized(MyLock.locka){
                    System.out.println("else......locka");
                }
            }
        }
    }
}

class MyLock{
    public static final Object locka = new Object();
    public static final Object lockb = new Object();
}
