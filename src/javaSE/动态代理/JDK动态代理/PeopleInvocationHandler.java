package javaSE.动态代理.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleInvocationHandler implements InvocationHandler {
    private Object obj;

    PeopleInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        System.out.println("-------- end ---------");
        return invoke;
    }
}
