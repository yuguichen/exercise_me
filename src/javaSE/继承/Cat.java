package javaSE.继承;

/**
 * 1、实例方法与引用变量实际引用的对象的方法进行绑定，这种绑定属于动态绑定，
 *   因为是在运行时由 Java 虚拟机动态决定的。
 *   例如，animal.eat() 是将 eat() 方法与 Cat 类绑定。
 *
 * 2、静态方法与引用变量所声明的类型的方法绑定，这种绑定属于静态绑定，
 *    因为是在编译阶段已经做了绑定。
 *    例如，animal.staticEat() 是将 staticEat() 方法与 Animal 类进行绑定。
 *
 * 3、成员变量（包括静态变量和实例变量）与引用变量所声明的类型的成员变量绑定，
 *    这种绑定属于静态绑定，因为在编译阶段已经做了绑定。
 *    例如， animal.name 和 animal.staticName 都是与 Animal 类进行绑定。
 */
public class Cat extends Animal{
    int i =10;
    public String name="Cat：猫";
    public String str="Cat：可爱的小猫";
    public static String staticName="Dog：我是喵星人";
    public void eat(){
        System.out.println("Cat：吃饭");
    }

    public static void staticEat() {
        System.out.println("Cat：猫在吃饭");
    }

    public void eatMethod() {
        System.out.println("Cat：猫喜欢吃鱼");
    }

    public static void main(String[] args) {
        Animal animal=new Cat();
        Cat cat=(Cat)animal;    //向下转型
        System.out.println(animal.name);    //输出Animal类的name变量
        System.out.println(animal.staticName);    // 输出Animal类的staticName变量
        animal.eat();    //输出Cat类的eat()方法
        animal.staticEat();    //输出Animal类的staticEat()方法
        System.out.println(cat.str);    //调用Cat类的str变量
        cat.eatMethod();    //调用Cat类的eatMethod()方法
        System.out.println(animal.i++);
        System.out.println(cat.i++);
        System.out.println(animal.i);
    }
}
