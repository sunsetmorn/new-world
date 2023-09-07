package leetcode.algorithm.section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 */
public class Solution78 {
    private static List<List<Integer>> combinationList = new ArrayList<>();
    private static int pos;
    private static int[] combination;

    public static List<List<Integer>> subsets(int[] nums) {
        combinationList.add(new ArrayList<>());
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            combination = new int[i];
            backtracking(n, 0, i, 0, nums);
        }
        return combinationList;
    }

    // 从 num 开始选择数字，填放 combination 数组的 idx 位置。
    private static void backtracking(int n, int num, int k, int idx,int[] nums) {
        if (n - num < k - idx) {
            return; // 剩余可选择的元素 < 需要的元素。
        }
        if (idx < k) {
            backtracking(n, num + 1, k, idx, nums);
            combination[idx] = nums[num];
            backtracking(n, num + 1, k, idx + 1, nums);
        } else {
            Integer[] newCombination = new Integer[k];
            for (int i = 0; i < k; i++) {
                newCombination[i] = combination[i];
            }
            combinationList.add(Arrays.asList(newCombination));
        }
    }


    public static void main(String[] args) {
        int[] a = {0};
        List<List<Integer>> subsets = subsets(a);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
