package javaSE.多线程;

/**
 * 等待唤醒机制学习
 * wait()\notify()
 */
public class 线程通信 {
    public static void main(String args[]){
        Resource resource = new Resource();
        Input input = new Input(resource);
        Output output = new Output(resource);

        Thread in = new Thread(input);
        Thread out = new Thread(output);

        in.start();
        out.start();
    }
}

class Resource{
    private String name;
    private String sex;
    private boolean flag = false;

    synchronized void set(String name, String sex){
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    synchronized void output(){
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"......."+sex);
        flag = false;
        this.notify();
    }
}

class Input implements Runnable{
    Resource resource;

    Input(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        int num = 0;
        while(true){
            if(num == 0)
                resource.set("zhangsan","nan");
            else
                resource.set("李四","女");
            num=(num+1)%2;
        }
    }
}

class Output implements Runnable{
    Resource resource;
    Output(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true){
            resource.output();
        }
    }
}