package go.to.maptest;

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
        System.out.println("使用entrySet+for遍历map开始：");
        for(Map.Entry entry: map.entrySet()) {
            // get key
            Integer key = (Integer)entry.getKey();
            System.out.print("[key:"+key);
            // get value
            String value = (String)entry.getValue();
            System.out.println(",value:" + value+"]");
        }

        /** Iterator+while map遍历 */
        System.out.println("使用Iterator+while遍历map开始：");
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
        System.out.println("根据Map的keys进行排序1,把Map.Entry放进list，再用Comparator对list进行排序：");
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
        System.out.println("根据Map的keys进行排序1,使用SortedMap+TreeMap+Comparator：");
        SortedMap sortedMap = new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer k1, Integer k2) {
                return k1.compareTo(k2);
            }
        });
        sortedMap.putAll(map3);
        ImmutableMap.output1(sortedMap);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, 2);
        map2.put(1, 5);
        map2.put(3, 4);
        /** 根据Map的value进行排序 */
        System.out.println("根据Map的value进行排序：");
        List<Map.Entry<Integer,Integer>> list2 = new ArrayList<>(map2.entrySet());
        Collections.sort(list2,Comparator.comparing((Map.Entry e) -> e.getValue().toString())
                //(Map.Entry e1, Map.Entry e2)-> {return e1.getKey().toString().compareTo(e2.getKey().toString());}
        );
        for (Map.Entry entry : list2) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}
