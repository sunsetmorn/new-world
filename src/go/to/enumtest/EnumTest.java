package go.to.enumtest;

public class EnumTest {

    /**
     *枚举类的创建1：直接创建
     */
    enum SeasonEnum {
        SPRING,SUMMER,FALL,WINTER;
    }

    /**
     * 枚举类的创建2：枚举类拓展，可以自建构造方法，添加成员变量和方法。
     * 枚举类继承java.lang.Enum,所以不能继承其他类，但是可以实现接口。
     *
     */
    public enum OrderStatusEnum{
        UNPAID(0, "未付款"), PAID(1, "已付款"), SEND(2, "已发货"), FINISH(3, "已完成"),;
        private int index;
        private String desc;
        public int getIndex() {return index; }
        public String getDesc() {return desc; }
        OrderStatusEnum(int index, String desc) { this.index = index;this.desc = desc; }
    }

    public static void main(String[] args) {
        /** 枚举类的使用SeasonEnum.SPRING */
        System.out.println(SeasonEnum.SPRING);
        /** 枚举类的直接引用的类型就是该枚举类 */
        System.out.println(SeasonEnum.SPRING instanceof SeasonEnum);

        /** 枚举类方法的使用SeasonEnum.SPRING */
        System.out.println(SeasonEnum.valueOf("SPRING"));
        /** valueOf()根据字符串返回枚举类中的常量值 */
        System.out.println(SeasonEnum.valueOf("SPRING") instanceof SeasonEnum);
        for (SeasonEnum aa:SeasonEnum.values()) {
            System.out.println(aa.name()+"在枚举类中的顺序是：" +aa.ordinal()+",和SeasonEnum.SPRING equals比较结果为:"
            + aa.equals(SeasonEnum.SPRING)+",和SeasonEnum.SPRING compareTo比较结果为:" +aa.compareTo(SeasonEnum.SPRING));
        }
    }


}
