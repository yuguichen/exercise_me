package 设计模式.工厂.工厂方法;

import 设计模式.工厂.工厂方法.ingredient.*;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Vaggies[] vaggies;
    Pepperoni pepperoni;
    Clams clams;

     abstract void prepare();

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box(){
        System.out.println("Place  pizza in offical PizzaStore box");
    }

    public String getName(){
        return name;
    }
}
