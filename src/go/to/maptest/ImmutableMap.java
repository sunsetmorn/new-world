package go.to.maptest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** 如何创建不可变的Map */
public class ImmutableMap {
    private static final Map<Integer,String> map;
    static {
        map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
    }
    private static final Map<Integer, String> map2;
    static {
        Map<Integer,String> aMap = new HashMap<>();
        aMap.put(1, "one");
        aMap.put(2, "two");
        map2 = Collections.unmodifiableMap(aMap);
    }

    public static void main(String[] args) {
        /** final+static 无法创建不可变的Map */
        map.put(3, "three");
        System.out.println("map:");
        output1(map);
        /** 使用unmodifiableMap 可以创建不可变的Map*/
        try{
            map2.put(3, "three");
        }catch(Exception e){
            System.out.println("map2不可变，插入数据会报错");
        }finally {
            System.out.println("map2:");
            output1(map2);
        }
    }

    static void output1(Map<Integer, String> map) {
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            // get key
            Integer key = (Integer) entry.getKey();
            // get value
            String value = (String) entry.getValue();

            System.out.println("key:"+key+",value:"+value);
        }
    }
}
