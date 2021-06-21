package go.to.reflecttest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射练习
 **/
public class Reflect {

    public static void main(String[] args){
        Student a =new Student();
        a.setName("Alun");
        a.setAge(17);
        a.introduce();
        try{
            /** 反射的基本应用 */
            Class clazz = Class.forName("go.to.reflecttest.Student");
            Method method1 = clazz.getMethod("setName", String.class);
            Method method2 = clazz.getMethod("setAge", Integer.class);
            Method method3 = clazz.getMethod("introduce");
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            method1.invoke(object, "Ketty");
            method2.invoke(object, 22);
            method3.invoke(object);

            /** 通过反射获取类的class对象的方法：1 、Class.forName，2、类名调用class，3、对象调用getClass()方法*/
            Class class1 = Class.forName("go.to.reflecttest.Student");
            Class class2 = Student.class;
            Class class3 = a.getClass();
            System.out.println("使用Class.forName获取Student类的class对象："+class1.getName());
            System.out.println("类名调用class获取Student类的class对象："+class2.getName());
            System.out.println("使用对象调用getClass()方法获取Student类的class对象:"+class3.getName());

            /** 反射创造对象的方法： 使用类的class对象调用newInstance()方法创建*/
            Object b = class1.newInstance();
            System.out.println("\n使用类的class对象调用newInstance()方法创建类对象"+b);

            /** 反射获取类的构造方法 */
            Constructor c = class1.getConstructor();
            Constructor[] d = class1.getDeclaredConstructors();
            Constructor e = class1.getDeclaredConstructor(String.class,Integer.class);
            Constructor[] f = class1.getConstructors();
            System.out.println("\nStudent类无参数的公共的构造方法是："+c + "\n");
            System.out.println("Student类所有的构造方法如下：");
            int i = 1 ;
            for(Constructor cc:d){
                System.out.println("第"+ i++ +"个是：" + cc);
            }
            System.out.println("\n根据String.class,Integer.class参数在所有构造方法中获取的构造方法是："+e + "\n");
            System.out.println("Student类所有的公共构造方法如下：");
            for(int j = 0 ;j < f.length ;j++){
                System.out.println("第"+ (j+1) +"个是：" + f[j]);
            }

            /** 反射获取类的属性 */
            Field fa =class1.getField("flag");
            Field fb =class1.getDeclaredField("name");
            Field[] fc=class1.getFields();
            Field[] fd=class1.getDeclaredFields();
            System.out.println("\nStudent类中名为flag的公共属性是："+fa);
            System.out.println("Student类的所有属性中名为name的属性是："+fb);
            System.out.println("Student类的中所有公共属性如下：");
            for(int j = 0 ;j < fc.length ;j++){
                System.out.println("第"+ (j+1) +"个是：" + fc[j]);
            }
            System.out.println("Student类的中所有属性如下：");
            for(int j = 0 ;j < fd.length ;j++){
                System.out.println("第"+ (j+1) +"个是：" + fd[j]);
            }

            /** 反射获取类的方法 */
            Method ma = class1.getMethod("getName");
            Method mb = class1.getDeclaredMethod("leaveUp");
            Method[] mc = class1.getMethods();
            Method[] md = class1.getDeclaredMethods();
            System.out.println("\nStudent类中名为getName的公共方法是："+ma);
            System.out.println("Student类中名为leaveUp的方法是："+mb);
            System.out.println("Student类中所有公共方法如下：");
            for(int j = 0 ;j < mc.length ;j++){
                System.out.println("第"+ (j+1) +"个是：" + mc[j]);
            }
            System.out.println("Student类中定义的所有方法如下：");
            for(int j = 0 ;j < md.length ;j++){
                System.out.println("第"+ (j+1) +"个是：" + md[j]);
            }
        }catch(Throwable e){
            System.out.println("调用反射报错："+e);
        }
    }
}
