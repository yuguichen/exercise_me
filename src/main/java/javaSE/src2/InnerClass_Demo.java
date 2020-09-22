package javaSE.src2;

/**
 * 学习内部类
 * 在内部类中可以随意调用外部类成员和方法，包括private方法和属性
 * 内部类方法和属性不能被外部类调用
 * 可以通过对象的方式调用
 * 内部类的实例化必须在外部类或外部类的非静态方法中完成
 *      InnerClass_Demo.Inner in1 =out.doit();
 *      InnerClass_Demo.Inner in2 =out.new Inner();
 *
 *
 * 复习
 * 非静态方法不能再静态方法区中直接调用
 * 非静态方法依赖于对象存在（对象。方法）
 * 非静态方法不能静态引用，即（类.方法）
 *
 */
public class InnerClass_Demo {

    Inner in = new Inner();

    public static void main(String args[]){
            InnerClass_Demo out=new InnerClass_Demo();
            InnerClass_Demo.Inner in1 =out.doit();
            InnerClass_Demo.Inner in2 =out.new Inner();
            //System.out.println(in.y);

    }

    public void show(){
        System.out.println("xxxxxxx");
    }

    public Inner doit(){
        in.y=4;
        return new Inner();
    }

    public void ouf(){
      //  in.inf();
    }

    class Inner{
        public Inner(){ System.out.println("内部类"); }
        int y=0;
        public void inf(){}
    }

}
