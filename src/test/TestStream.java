package test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("hyui");
        list.add("njbhyu");
        list.add("qoeu");

        List<String> list2 = list.stream().filter(s-> s.equals("hyui")).collect(Collectors.toList());

        list2 = list.stream().filter(
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.equals("hyui");
                    }
                }
        ).collect(Collectors.toList());
        list2.forEach(a -> System.out.println(a));

        Map<String,String> list3 = list.stream().collect(
                () -> new HashMap<>(),
                (o, s) -> o.put(s,s),
                (BiConsumer<Map, Map>) (o, o2) -> o.putAll(o2)
        );


    }
}
