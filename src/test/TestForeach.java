package test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * foreach��������Ǻ���ʽ�ӿڡ�
 * ���Դ�������ʵ�ָĽӿڵ��࣬����lambda���ʽ��
 */
public class TestForeach {
    public static void main(String[] args) {
        List<C> list = new ArrayList<>();
        list.add(new C());
        list.add(new C());
        list.add(new C());
        list.add(new C());
        list.forEach((a)->System.out.println(a));

        list.forEach(
            new Consumer<A>() {
                @Override
                public void accept(A a) {
                    a.tt();
                }
            }
        );
    }

    static class A {
        void tt(){
            System.out.println("tt");
        }
    }

    static class C extends A {
        void rr(){
            System.out.println("rr");
        }
    }
}
