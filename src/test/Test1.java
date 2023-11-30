package test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) throws ParseException {
        Po po = new Po();
        po.setAa("11");
        Field[] declaredFields = po.getClass().getDeclaredFields();
        for (Field t:declaredFields) {
            System.out.println(t);
        }
    }

    static class Po{
        private String aa;
        public void setAa(String aa){
            this.aa=aa;
        }

        public String getAa(){
            return this.aa;
        }

    }
}
