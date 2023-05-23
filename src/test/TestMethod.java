package test;

public class TestMethod {

    public static void main(String[] args) {
        String a = "111";
        int b = 2;
        System.out.println("a="+a);
        System.out.println("b="+b);
//        test1(a,b);
//        System.out.println("a="+a);
//        System.out.println("b="+b);
        test1(a,b++);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }


    static String test1(String a,int b){
        System.out.println("方法内");
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("经过方法转换后");
        return "";
    }


}
