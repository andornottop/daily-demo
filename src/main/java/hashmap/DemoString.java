package hashmap;

import java.util.*;

public class DemoString {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>() {{
            put("a", "我");
            put("d", "很好");
            put("c", "你");
            put("b", "他");
        }};
        System.out.println(map.toString());

        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

        System.out.println(list.toString() + "前");

        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        /*Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));*/

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list.toString() + "后");

        Iterator<Map.Entry<String, String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
