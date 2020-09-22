package javaSE.多线程;

public class isAlive方法Demo {
    public static void main(String args[]){

        CountOperate c = new CountOperate();
       // c.start();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        //本条语句结果不确定，由线程执行情况确定
        System.out.println("main end t1 isAlive=" + t1.isAlive());

    }
}

class CountOperate extends Thread{

    public CountOperate(){
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());//获取线程名
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive()); //查看线程是否存活
        System.out.println("this.getName=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOperate---end ");
        System.out.println("Thread.currentThread()==this :"+ (Thread.currentThread() == this));
        System.out.println("-------------------------");
        System.out.println("-------------------------");
    }

    @Override
    public void run() {
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());

        //  false  因为这里this和Thread.currentThread()所指的并不是同一个线程实例
        //  this 指的是new CountOperate();的实例对象
        //  Thread.currentThread()指的是new Thread(c);的实例对象，即正在运行的线程对象
        System.out.println("Thread.currentThread()==this :"+ (Thread.currentThread() == this));
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("run --- end");
        System.out.println("-------------------------");
        System.out.println("-------------------------");
    }
}
