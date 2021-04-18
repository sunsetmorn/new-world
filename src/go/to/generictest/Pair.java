package go.to.generictest;
/**
 * 泛型类
 *
 */

//常见的如T、E、K、V等形式的参数常用于表示泛型，编译时无法知道它们类型，实例化时需要指定。
public class Pair <K,V>{
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public static void main(String[] args) {
        // 此处K传入了Integer，V传入String类型
        Pair<Integer,String> pairInteger = new Pair<>(1, "第二");
        System.out.println("泛型测试，first is " + pairInteger.getFirst()
                + " ,second is " + pairInteger.getSecond());
    }
}

