package go.to.maptest;

import java.sql.SQLOutput;
import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "张三");
        map.put(1, "李四");
        map.put(3, "王五");
        /** 把一个map的键转化为list */
        List<Integer> keyList = new ArrayList<>(map.keySet());
        System.out.println(keyList);

        /** 把map的值转化为list */
        List<String> valueList = new ArrayList<>(map.values());
        System.out.println(valueList);

        /** 把map的键值转化为list */
        List entryList = new ArrayList(map.entrySet());
        System.out.println(entryList);

        /** entrySet+for map遍历 */
        System.out.println("\n使用entrySet+for遍历map开始：");
        for(Map.Entry entry: map.entrySet()) {
            // get key
            Integer key = (Integer)entry.getKey();
            System.out.print("[key:"+key);
            // get value
            String value = (String)entry.getValue();
            System.out.println(",value:" + value+"]");
        }

        /** Iterator+while map遍历 */
        System.out.println("\n使用Iterator+while遍历map开始：");
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            // get key
            Integer key = (Integer)entry.getKey();
            System.out.print("[key:"+key);
            // get value
            String value = (String)entry.getValue();
            System.out.println(",value:" + value+"]");
        }

        /** 根据Map的keys进行排序1 */
        System.out.println("\n根据Map的keys进行排序1,把Map.Entry放进list，再用Comparator对list进行排序：");
        List<Map.Entry<Integer,String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,Comparator.comparing((Map.Entry e) -> e.getKey().toString())
            //(Map.Entry e1, Map.Entry e2)-> {return e1.getKey().toString().compareTo(e2.getKey().toString());}
        );
        for (Map.Entry entry : list) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /** 根据Map的keys进行排序2 */
        Map<Integer, String> map3 = new HashMap<>();
        map3.put(2, "张三");
        map3.put(1, "李四");
        map3.put(3, "王五");
        System.out.println("\n根据Map的keys进行排序1,使用SortedMap+TreeMap+Comparator：");
        SortedMap sortedMap = new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer k1, Integer k2) {
                return k1.compareTo(k2);
            }
        });
        sortedMap.putAll(map3);
        Iterator itr = sortedMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            // get key
            Integer key = (Integer) entry.getKey();
            // get value
            String value = (String) entry.getValue();
            System.out.println("key:"+key+",value:"+value);
        }

        /** 根据Map的value进行排序 */
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, 2);
        map2.put(1, 5);
        map2.put(3, 4);
        System.out.println("\n根据Map的value进行排序：");
        List<Map.Entry<Integer,Integer>> list2 = new ArrayList<>(map2.entrySet());
        Collections.sort(list2,Comparator.comparing((Map.Entry e) -> e.getValue().toString())
                //(Map.Entry e1, Map.Entry e2)-> {return e1.getKey().toString().compareTo(e2.getKey().toString());}
        );
        for (Map.Entry entry : list2) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /** Map用=复制 复制指针*/
        System.out.println("\nMap用=复制 start");
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("jay",22));
        userMap.put(2, new User("fany",22));
        Map<Integer, User> clonedMap = userMap;
        System.out.println("userMap为："+userMap);
        System.out.println("clonedMap为："+clonedMap);
        clonedMap.get(1).setName("Candy");
        System.out.println("改变clonedMap的中的一个值后");
        System.out.println("userMap为："+userMap);
        System.out.println("clonedMap为："+clonedMap);
        System.out.println("Map用=复制 end");

        /** Map用clone复制 复制指针*/
        System.out.println("\nMap用clone复制 start");
        HashMap<Integer, User> userMap2 = new HashMap<>();
        userMap2.put(1, new User("jay", 26));
        userMap2.put(2, new User("fany", 25));
        HashMap<Integer, User> clonedMap2 = (HashMap<Integer, User>) userMap2.clone();
        System.out.println("userMap2为："+userMap2);
        System.out.println("clonedMap2为："+clonedMap2);
        System.out.println("改变clonedMap2的中的一个值后");
        clonedMap2.get(1).setName("test");
        System.out.println("userMap2为："+userMap2);
        System.out.println("clonedMap2为："+clonedMap2);
        System.out.println("Map用clone复制 end");

        /** Map用putAll复制 复制指针*/
        System.out.println("\nMap用putAll复制 start");
        HashMap<Integer, User> userMap3 = new HashMap<>();
        userMap3.put(1, new User("jay", 26));
        userMap3.put(2, new User("fany", 25));
        HashMap<Integer, User> clonedMap3 = new HashMap<>();
        clonedMap3.putAll(userMap3);
        System.out.println("userMap3为："+userMap3);
        System.out.println("clonedMap3为："+clonedMap3);
        System.out.println("改变clonedMap3的中的一个值后");
        clonedMap3.get(1).setName("Ketty");
        System.out.println("userMap3为："+userMap3);
        System.out.println("clonedMap3为："+clonedMap3);
        System.out.println("Map用putAll复制 end");

        /** Map用使用遍历实现复制 */
        System.out.println("\nMap用使用序列化实现复制 start");
        HashMap<Integer, User> userMap4 = new HashMap<>();
        userMap4.put(1, new User("jay", 25));
        userMap4.put(2, new User("fany", 26));
        HashMap<Integer, User> clonedMap4 = new HashMap<>();
        Iterator itrr = userMap4.entrySet().iterator();
        Integer i = 1;
        while(itrr.hasNext()) {
            Map.Entry k =  (Map.Entry)itrr.next();
            User u1 = (User)k.getValue();
            User u2 = new User(u1.getName(),24+i);
            clonedMap4.put(i++,u2);
        }
        System.out.println("userMap4为："+userMap4);
        System.out.println("clonedMap4为："+clonedMap4);
        clonedMap4.get(1).setName("gg");
        System.out.println("userMap4为："+userMap4);
        System.out.println("clonedMap4为："+clonedMap4);
        System.out.println("Map用使用序列化实现复制 end");
    }
}
