package go.to.generictest;

public class Genericmethods {

    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        Genericmethods gm = new Genericmethods();
        gm.f("字符串");
        gm.f(666);
    }
}
