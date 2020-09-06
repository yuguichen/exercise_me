package javaSE.反射;

import javaSE.src2.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * javaSE.反射：
 * 动态获取类中的信息；
 * 通过接口和配置文件获取；
 *
 * 反射机制第一步：
 *     获取字节码文件；
 *
 *
 */

public class ReflectDemo1 {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        getClassObject_1();
        getClassObject_2();

    }

    /**
     * 获取类的字节码文件
     * 1、
     * 任何数据类型都具备一个静态的属性 （.class）来获取其对应的class对象
     * 但局限于要明确用到类中的静态成员
     */
    public static void getClassObject_1(){
        Class clazz = Person.class;
        Class clazz1= Person.class;
        System.out.println(clazz==clazz1);
    }

    /**
     * 2、通过给定类的字符串名称可以获取该类
     *    用class类中的  forName（）方法就可以完成；
     */
    public static void getClassObject_2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "javaSE.src2.Person";
        Class clazz = Class.forName(className);
        Class clazz1= Class.forName(className);
        System.out.println(clazz==clazz1);

        // 获取字节码文件后创建实例对象
        Object obj = clazz.newInstance();
    }

    public static void CreateNewObject2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String className = "javaSE.src2.Person";
        Class clazz = Class.forName(className);

        //获取指定的构造函数对象
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        //通过构造器对象的newInstance方法创建对象并初始化
        Object obj = constructor.newInstance("xiaoming",24);

    }
}


