package 设计模式.工厂.工厂方法;

import 设计模式.工厂.工厂方法.ingredient.*;

/**
 * 这部分已经是  抽象工厂模式
 * 某一特定的原料工厂（可以有很多）
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new Dough();
    }

    @Override
    public Sauce createSauce() {
        return new Sauce();
    }

    @Override
    public Cheese createCheese() {
        return new Cheese();
    }

    @Override
    public Vaggies[] createVaggies() {
        Vaggies vaggies[] = {new Vaggies(), new Vaggies()};
        return vaggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    @Override
    public Clams createClams() {
        return new Clams();
    }
}
