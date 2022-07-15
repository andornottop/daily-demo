package hashmap;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("d", 2);
            put("c", 3);
            put("b", 4);
        }};
        System.out.println(map.toString());

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        System.out.println(list.toString() + "前");

        Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());

        /*Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });*/
        System.out.println(list.toString() + "后");

        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
