package 设计模式.工厂.简单工厂;

/**
 * 父类已经确定Pizza制作流程，子类只需初始化不同参数代表不同种类pizza
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza(){
        name = "NY Style sauce and cheese Pizza";
        dough = " Thin Crust Dough";
        sauce = " Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
