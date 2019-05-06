package javaSE.src2;

/**
 *
 * 内部类向上转型为接口
 * 定义private内部类，所以只能有外部类OuterClass访问，其他类不能访问
 * 可以通过doit（）方法将内部类对象向上转型为接口类型，并可以调用接口内的方法
 * 非内部类不能被定义为private和protected类型
 */

interface  OutInterface{
    public void f();

}
public class InterfaceInner {
    public static void main(String args[]){
        OuterClass out = new OuterClass();
        OutInterface outinter = out.doit();
        outinter.f();

        //OuterClass.InnerClass inner =out.doit2();
        //inner.show();
    }


}

class OuterClass{
    //定义private内部类，所以只能有外部类OuterClass访问，其他类不能访问
    //可以通过doit（）方法将内部类对象向上转型为接口类型，并可以调用接口内的方法
    private class InnerClass implements OutInterface{
        InnerClass(String s){
            System.out.println(s);
        }
        @Override
        public void f() {
            System.out.println("访问内部类中的f()方法");
        }

        public void show(){
            System.out.println("show方法");
        }
    }

    public OutInterface doit(){
        return new InnerClass("访问内部类构造方法");
    }

    //因private内部类，因此无法创建内部类引用，即OuterClass.InnerClass outinner
    //public InnerClass doit2(){
    //    return new InnerClass("访问内部类构造方法");
    //}
}
