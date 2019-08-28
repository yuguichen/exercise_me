package 设计模式.工厂.简单工厂;

/**
 * 简单工厂，用于创建对象
 *
 */
public class SimplePizzaFatory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        // 根据不同条件决定创建不同对象
        if(type.equals("cheese")){
            pizza = new NYStyleCheesePizza();
        }

        return pizza;
    }
}
