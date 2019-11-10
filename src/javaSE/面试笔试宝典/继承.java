package javaSE.面试笔试宝典;

public class 继承 extends Base{
    static int i = 20;
    public static void main(String args[]){
        继承 base = new 继承(100);
        base.show();
    }

    public void show(){
        System.out.println("子类"+i);
    }

    继承(){
        System.out.println("子类构造......"+i);
    }
    继承(int i){
        this.i = i;
        System.out.println("子类构造......"+i);
    }

}

class Base{
    int i = 10;

    Base(){
        System.out.println("父类构造.............."+i);
        show();
    }
    public void show(){
        System.out.println("base"+i);
    }
}