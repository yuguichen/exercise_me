package 设计模式.单例;

/**
 *     1、单例类只能有一个实例。
 * 　　2、单例类必须自己创建自己的唯一实例（私有构造函数）。
 * 　　3、单例类必须给所有其他对象提供这一实例。
 */
public class Singleton {

}


/**
 *  1、饿汉式：
 *      类加载时完成初始化（加载慢）；
 *      线程安全
 */
class Singleton1{
    private static Singleton1 instance = new Singleton1();
    // 私有构造方法
    private Singleton1(){}
    // 静态方法
    public static Singleton1 getInstance(){
        return instance;
    }
}

/**
 *  2、懒汉式：
 *      第一次调用时创建实例
 *      线程不安全
 */
class Singleton2{
    private static Singleton2 instance;
    private Singleton2 (){
    }
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}


/**
 *  3、懒汉式：
 *      第一次调用时初始化
 *      线程安全（同步函数 或 同步代码块）
 */
class Singleton3{
    // volatile 保证可见性同时禁止指令重排 双重判断有用
    private volatile static Singleton3 instance;

    private Singleton3(){}

    // 同步函数
    public static synchronized Singleton3 getInstance1(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }


    /**
     *   同步代码块+双重判（效率高）
     *   但是在某些情况会出现失效的问题（创建对象时重排序导致）， 所以使用volatile关键字禁止重排序，解决失效问题
     *   创建对象的重排序：因为创建对象 instance = new Singleton3(); 不是原子性操作：
     *                         1 分配内存空间；
     *                         2 调用构造函数，初始化成员字段；
     *                         3 将对象指向内存空间；（这步完成后，对象就不是null）
     *    这三步不是原子性，不一定保证顺序 1-2-3 或 1-3-2
     *    若有两个线程：线程1在执行到 instance = new Singleton3();时，按照1-3-2顺序执行；
     *                  同时线程1执行到3时，
     *                  线程2执行第一个if(instance == null)判断则会判断为非空，直接返回对象，不进入同步代码块；
     *                  导致导致线程2得到的是一个错误的实例对象；比如某些成员字段还未完成初始化。
     *
     */
    public static Singleton3 getInstance2(){
        // 第一次是为了不必要的同步
        if(instance == null){
            synchronized(Singleton3.class){
                // 第二次是在singleton等于null的情况下才创建实例
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 *  4、静态内部类
 *     第一次加载Singleton类时并不会初始化sInstance，
 *     只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance （类初始化是非并行的）;
 *     这样不仅能确保线程安全;
 *     也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
 */
class Singleton4{
    private Singleton4(){}

    public static final Singleton4 getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final Singleton4 sInstance = new Singleton4();
    }
}

