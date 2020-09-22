package 设计模式.工厂.工厂方法;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza(new NYPizzaIngredientFactory());
        } else {
            return null;
        }
    }
}
