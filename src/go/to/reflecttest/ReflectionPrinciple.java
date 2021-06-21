package go.to.reflecttest;

import java.lang.reflect.Method;

/** 深入了解反射的底层调用机制 */
public class ReflectionPrinciple {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("go.to.reflecttest.ReflectionPrinciple");
        Method method = clazz.getMethod("target", String.class);
        method.invoke(null, "666");
    }

    public static void target(String str) {
        //打印堆栈信息
        new Exception("#" +str).printStackTrace();
        System.out.println("invoke target method");
    }
}
