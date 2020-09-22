package 设计模式.工厂.工厂方法;

import 设计模式.工厂.工厂方法.ingredient.*;

/**
 * 原料接口
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Vaggies[] createVaggies();
    public Pepperoni createPepperoni();
    public Clams createClams();

}
