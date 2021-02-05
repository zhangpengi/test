package Set;

import java.util.*;

public class TestDemo {


    public static void func(String str1,String str2) {
        Set<Character> set1 = new HashSet<>();
        for (char ch : str2.toUpperCase().toCharArray()) {
            set1.add(ch);
        }

        Set<Character> set2 = new HashSet<>();
        for (char ch2 : str1.toUpperCase().toCharArray()) {
            if (!set1.contains(ch2) && !set2.contains(ch2)) {
                set2.add(ch2);
                System.out.println(ch2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String str1 = scr.nextLine();
        String str2 = scr.nextLine();
        func(str1,str2);
    }

    //找出数组中没有重发的数字 1.练习 Set 2.用异或 ^
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        for(int i : nums) {
            if(set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int single(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }

    public static void main5(String[] args) {
        int[] num = {2,2,1};
        System.out.println(singleNumber(num));
    }

    public static void main4(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }

        //遍历 list
        for (Integer key : list) {
            if (map.get(key) == null) {
                map.put(key,1);
            } else {
                int val = map.get(key);
                map.put(key,val + 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + "次数" + entry.getValue());
            }

        }
    }


    //有 10 万个数据，去重
    public static void main3(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            set.add(list.get(i));
            System.out.println(set);
        }
    }
    //有 10 万个数据，找到第一个重复的数据
    public static void main2(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            if (set.contains(list.get(i))) {
                System.out.println(list.get(i));
                return;
            } else {
                set.add(list.get(i));
            }
        }

    }

    public static void main1(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("12345");
        set.add("12");
        set.add("123");

        System.out.println(set);
        Iterator<String> it = set.iterator();//迭代器
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
