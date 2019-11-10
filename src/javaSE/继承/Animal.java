package javaSE.继承;

public class Animal {
    int i= 0;
    public String name="Animal：动物";
    public static String staticName="Animal：可爱的动物";
    public void eat() {
        System.out.println("Animal：吃饭");
    }

    public static void staticEat() {
        System.out.println("Animal：动物在吃饭");
    }
}
