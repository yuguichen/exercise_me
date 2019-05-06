package javaSE.多线程;

public class 强制停止线程 {
    public static void main(String args[]){

        SynchronizedObject object =new SynchronizedObject();
        MyThread1 myThread1 = new MyThread1(object);
        myThread1.start();
        try {
            Thread.sleep(500); // 不释放锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         //myThread1.stop();//暴力停止
        System.out.println(object.getUsername()+" "+object.getPassword());
    }
}

class MyThread1 extends Thread{
    private SynchronizedObject object;
    public MyThread1(SynchronizedObject object){
        super();
        this.object = object;
    }

    public void run(){
        object.printString("b","bb");
    }
}

class SynchronizedObject{
    private String username = "a";
    private String password = "aa";

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

   synchronized public void printString(String username , String password){
        try{
            this.username = username;
            Thread.sleep(400);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }


}
