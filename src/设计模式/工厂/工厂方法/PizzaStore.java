package 设计模式.工厂.工厂方法;

/**
 * 父类：并不知道顾客要点的是什么种类的pizza；
 *       也就是说父类并不知道要具体实例那个对象，交由子类去实现；
 *
 * 相对于简单工厂：将创建对象的功能有实体类改为抽象方法，并由实现类决定创建什么对象
 *                 实现进一步解耦；
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza( String type);
}
