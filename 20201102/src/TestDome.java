import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
//: www.algorithm.show
//员工的重要性：
class Solution2 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee employee:employees) {
            map.put(employee.id,employee);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int oneLeve1 = 1,sum = 0;
        while(!queue.isEmpty()) {
            while(oneLeve1 -- > 0) {
                int tmp = queue.poll();
                sum += map.get(tmp).importance;
                for (int subordinates : map.get(tmp).subordinates) {
                    queue.offer(subordinates);
                }
            }
            oneLeve1 = queue.size();
        }
        return sum;
    }
}
//找到小镇的法官:
//在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
// 如果小镇的法官真的存在，那么：
//小镇的法官不相信任何人。
//每个人（除了小镇法官外）都信任小镇的法官。
//只有一个人同时满足属性 1 和属性 2 。
//给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
//如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

class Solution4 {
    public  int findJudge(int N, int[][] trust) {
        //List<Integer> ret = new ArrayList<>();
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        for (int[] t: trust) {
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }
        int judge = -1;
        for (int i = 1; i <= N ; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                judge = i;
                break;
            }
        }
        return judge;
    }
}
//二维网格迁移
/*
位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
*/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /*int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> curRow = new ArrayList<>();//当前行
            curRow.add(grid[m-1][n-1]);
            for (int j = 0; j < n; j++) {

            }

            }
        }*/
        List ret = new ArrayList<>();
        int m = grid.length;
        if (m == 0) return ret;
        int n = grid[0].length;
        int[][] newgrid =new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newgrid[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
            }
        }
        ret =  Arrays.asList(newgrid);
        return ret;

    }
}

    /*Stack input = new ArrayList;
        for(int i = 0; i < pushA.length; i++) {
        input.push(pushA[i]);
        for(int j = 0; j < popA.length; j++) {
        if (pushA[0] == popA[0] || popA[popA.length - 1] == pushA[0] ||
        popA[j + 1] == pushA[0]  ){
        return true;
        }
        }
        }
        return false;
        }
        }*/
public class TestDome {
    public static void main(String[] args) {

    }
    public static void main1(String[] args) {
        Solution4 solution = new Solution4();
        int N = 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(solution.findJudge(N, trust));
    }

}
