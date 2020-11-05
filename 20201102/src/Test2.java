import java.util.ArrayList;
import java.util.List;
class Solution1 {
    public boolean canThreePartsEqualSum(int[] A) {
        //遍历数组A求数组分成3等分的平均数
        int sum = 0;//定义一个和 sum
        for (int num = 0; num < A.length; num++) {
            sum += A[num];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int avg = sum / 3;
        int n = A.length, i = 0, count = 0;
        while (i < n) {
            count += A[i];
            if (count == avg) {
                break;
            }
            ++i;
        }
        if (count != avg) {
                return false;
        }

        int j = i + 1;
        while (j + 1 < n) {
            count += A[j];
            if (count == avg * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }
}/*
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid.length;

        int[][] agrid = new int[][]
    }
}*/
public class Test2 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(99);
        myLinkedList.addAtTail(88);
        myLinkedList.display();
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(2));
        //myLinkedList.deleteAtIndex(2);
        //myLinkedList.display();
        myLinkedList.addAtIndex(4,4);
        myLinkedList.display();
    }
    public static void main1(String[] args) {
        int[] arr =new int[] {0,2,1,-6,6,-7,9,1,2,0,1};
        Solution1 solution = new Solution1();
        System.out.println(solution.canThreePartsEqualSum(arr));

    }
}
