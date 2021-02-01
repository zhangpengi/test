import com.sun.xml.internal.ws.api.pipe.Fiber;

import java.util.Arrays;

public class Main {
    //非递归归并排序
    public static void mergeNor(int[] array,int gap) {
        int len = array.length;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < len ? s2 + gap -1 : len - 1;
        int[] tmp = new int[len];
        int k = 0;

        while (s2 < len) {           //判断有两个归并段
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmp[k] = array[s1];
                    k++;
                    s1++;
                } else {
                    tmp[k] = array[s2];
                    k++;
                    s2++;
                }
            }
            while (s1 <= e1) {
                tmp[k++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[k] = array[s2];
                k++;
                s2++;
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < len ? s2 + gap - 1 : len - 1;
        }
        while (s1 <= len - 1) {
            tmp[k] = array[s1];
            k++;
            s1++;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }

    }

    public static void mergeSortNor(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            mergeNor(array,i);
        }
    }

    //非递归斐波那契
    public static int Fibonacci(int n) {
        int F1 = 0;
        int F2 = 1;
        int F3 = 0;
        int k = 2;
        if(n <= 1) {
            return n;
        }
        while(n >= 2 && k <= n) {
            F3 = F2 + F1;
            F1 = F2;
            F2 = F3;
            k++;
        }
        return F3;
    }
    //递归斐波那契
    public static int Fib(int n) {
        if (n < 2) {
            return n;
        }
        return Fib(n - 1) + Fib(n - 2);
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,56,34,25,66};
        System.out.println(Arrays.toString(array));
        mergeSortNor(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Fibonacci(45));
        System.out.println(Fib(45));
    }
}
