import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    /**
    直接插入排序：
    稳定性：稳定
    空间复杂度：O(1)
    时间复杂度：
      最坏情况下：O(n^2) 数组中的数据是无序的
      最好情况下：O(n) 数组有序的时候
    特点：给定的一组数据越有序越快
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /**
    希尔排序：
    稳定行：不稳定（有跳跃式的交换）
    时间复杂度：O(n^1.3) - O(n^1.5)
    空间复杂度：O(1)
     */
    public static void shell(int[] array,int gap) {
        for (int j = gap; j < array.length; j++) {
            int tmp = array[j];
            int k = j-gap;
            for (; k >= 0; k = k - gap) {
                if (array[j] < array[k]) {
                    array[k+gap] = array[k];
                }else {
                    break;
                }
            }
            array[k+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    /**
    选择排序
    时间复杂度：O(n^2)
    空间复杂度：O(1)
    稳定行：不稳定
     */
    public static  void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    /**
    堆排序
    时间复杂度：O(n*log n)
    空间复杂度：O(1)
    稳定性：不稳定
     */
    public static void adjustDown(int[] array,int parent,int len){
        int child = 2*parent+1;
        while (child < len) {
            if (child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }

     public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0]= array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
     }
     /**
     快速排序：
     时间复杂度：O(n*log n)
     空间复杂度：O(log n)
     稳定性：不稳定
      */
    //public static  void

    public static void main(String[] args) {
        int[] array = {10,7,3,6,8,5};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));

    }
}
