import java.util.*;
public class Test {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        */
    }
    public static void main2(String[] args) {
        Integer i = 200;//装箱 valueOf
        int b = i.intValue(); //拆箱
        double d = i.doubleValue();//显示拆箱
    }
    public static void main1(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("悟能","八戒");
        map.put("吴泾","ddd");
        //map中存放的元素的顺序，不一定是打印的顺序
        //原因是存放数据的方式不一样，根据某一个规则
        //key值可以重复，value为最后以此放进去的值
        //key和value可以为null
        System.out.println(map);
        System.out.println(map.get("悟能"));
        System.out.println(map.getOrDefault("1", "www"));
        //如果有key对应的值，则返回value，否则返回默认defaultvalue
        //Set<Map.Entry<String, String>> = //9:51

    }
    //Collection<Integer> collection = new ArrayList<>();


}
