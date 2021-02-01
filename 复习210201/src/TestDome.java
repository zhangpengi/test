/*
泛型的练习
2021-02-01
 */

/**
 * 泛型的上界  extends
 */
public class TestDome {
    static class GenericAlg<T extends Comparable<T>> {
        public T MaxValue(T[] array) {
            T max = array[0];
            for (T t : array) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }

    }

    static class GenericAlg2 {
        public static<T extends Comparable<T>> T MaxValue(T[] array) {
            T max = array[0];
            for (T t : array) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }

    }
    public static void main(String[] args) {
        Integer[] array = {1,3,5,6,2};
        GenericAlg<Integer> genericAlg = new GenericAlg<>();
        System.out.println(genericAlg.MaxValue(array));
        System.out.println(GenericAlg2.<Integer>MaxValue(array));
    }
}
