package go.to.generictest.interfacetest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringGenerator implements Generator<String> {
    @Override
    public String next() {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(d));
        return df.format(d);
    }
}
