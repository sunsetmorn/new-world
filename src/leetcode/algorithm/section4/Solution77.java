package leetcode.algorithm.section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 */
public class Solution77 {
    static List<List<Integer>> ret = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        List<Integer> list = new ArrayList<>();
        add(list,num,k,0);
        return ret;
    }

    private static void add(List<Integer> a,List<Integer> b,int k,int flag){
        for (int i = flag; i < b.size(); i++) {
            if(b.size() - flag + a.size() < k ){
                return;
            }
            int tmp = b.get(i);
            a.add(b.get(i));
            b.remove(i);
            if(a.size() < k){
                add(a,b,k,i);
            }else {
                ret.add(new ArrayList<>(a));
            }
            a.remove(a.size() - 1);
            b.add(i,tmp);
        }
    }

    private static List<Integer>[] combinationList;
    private static int pos;
    private static int[] combination;

    public static List<List<Integer>> combine2(int n, int k) {
        combinationList = new List[getCombine(n, k)];
        combination = new int[k];
        backtracking(n, 1, k, 0);
        return Arrays.asList(combinationList);
    }

    // 从 num 开始选择数字，填放 combination 数组的 idx 位置。
    private static void backtracking(int n, int num, int k, int idx) {
        if (n - num + 1 < k - idx) {
            return; // 剩余可选择的元素 < 需要的元素。
        }
        if (idx < k) {
            backtracking(n, num + 1, k, idx);
            combination[idx] = num;
            backtracking(n, num + 1, k, idx + 1);
        } else {
            Integer[] newCombination = new Integer[k];
            for (int i = 0; i < k; i++) {
                newCombination[i] = combination[i];
            }
            combinationList[pos++] = Arrays.asList(newCombination);
        }
    }

    // 计算 C(n, k) 的组合数。
    private static int getCombine(int n, int k) {
        long x = 1, y = 1;
        for (int i = 1; i <= k; i++) {
            y *= i;
            x *= n - i + 1;
        }
        return (int) (x / y);
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(5, 3);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
}
