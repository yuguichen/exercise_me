package 设计模式.工厂.工厂方法;

/**
 * 父类已经确定Pizza制作流程，子类只需初始化不同参数代表不同种类pizza
 */
public class NYStyleCheesePizza extends Pizza {
    // 通过原料工厂来添加原料
    PizzaIngredientFactory ingredientFactory;

    public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
