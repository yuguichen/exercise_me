package javaSE.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer_Consumer {
    public static void main(String args[]){
        Resources resources = new Resources();
        Producer producer = new Producer(resources);
        Consumer consumer = new Consumer(resources);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(producer);
        Thread thread3 = new Thread(consumer);
        Thread thread4 = new Thread(consumer);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Resources{

    //创建锁和监视器对象
    Lock lock = new ReentrantLock();
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    private Object[] items = new Object[200];
    int count,putptr,takeptr;

    /**
     * 生产行为
     * @param obj
     * @throws InterruptedException
     */
    public void produce(Object obj) throws InterruptedException {
        lock.lock();
        try {
            while(count == items.length)
                producer_con.await();
            items[putptr] = obj;
            if(++putptr==items.length)
                putptr = 0;
            count++;
            consumer_con.signal();
            System.out.println(Thread.currentThread().getName()+"....生产......"+obj);
        } finally {
            lock.unlock();
        }

    }

    /**
     * 消费行为
     * @return
     * @throws InterruptedException
     */
    public Object consume() throws InterruptedException {
        lock.lock();
        try{
            while(count == 0)
                consumer_con.await();
            Object obj = items[takeptr];
            if(++takeptr == items.length)
                takeptr = 0;
            count--;
            producer_con.signal();
            System.out.println(Thread.currentThread().getName()+"........消费.........."+obj);
            return obj;
        }finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable{
    private Resources resources;
    Producer(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run() {
        while(true){
            try {
                resources.produce(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Resources resources;
    Consumer(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run(){
        while(true){
            try {
                Object object = resources.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
