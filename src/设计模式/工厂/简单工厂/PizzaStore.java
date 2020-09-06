package 设计模式.工厂.简单工厂;

/**
 * 父类：并不知道顾客要点的是什么种类的pizza；
 *       也就是说父类并不知道要具体实例那个对象，交由子类去实现；
 */
public abstract class PizzaStore {
    SimplePizzaFatory simplePizzaFatory;

    public PizzaStore(SimplePizzaFatory simplePizzaFatory){
        this.simplePizzaFatory = simplePizzaFatory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = simplePizzaFatory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
