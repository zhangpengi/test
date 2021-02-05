package map;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("齐天大圣","孙悟空");
        System.out.println(map.get("齐天大圣"));

        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
