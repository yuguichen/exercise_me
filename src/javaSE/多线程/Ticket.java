package javaSE.多线程;

/**
 * 线程安全问题：
 *      对于线程间共享资源，多个线程同时访问
 * 解决方法：
 *      使用synchronized同步关键字持有对象锁
 */
public class Ticket implements Runnable {
    private int ticketNum = 20;
    @Override
    public void run() {
        while(true){
            synchronized(this){
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName()+"......."+ticketNum--);
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        Thread thread4 = new Thread(ticket);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
