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




    /**
     * 记原序列中元素的总数为 nnn。原序列中的每个数字的状态可能有两种，即「在子集中」和「不在子集中」。
     * 我们用 1 表示「在子集中」，0 表示不在子集中，那么每一个子集可以对应一个长度为 n 的 0/1 序列
     * 可以发现 0/1 序列对应的二进制数正好从 0 到 2^n−1。我们可以枚举 mask∈[0,2^n−1]，mask的二进制表示是一个 0/1序列，
     * 我们可以按照这个 0/1序列在原集合当中取数。当我们枚举完所有 2^n个 mask，我们也就能构造出所有的子集。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets3(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * 对于数组中的所有位置，都有包含和不包含两种情况。
     * 使用递归对每个位置选和不选进行分别推进，直到所有位置都选择完成后添加到结果队列中。（可以理解成使用递归的方式对二元结构进行遍历）
     *
     * cur表示当前位置，第一次递归前添加当前位置的数字，本次递归表示选择包含cur位置的数字的所有情况。
     * 后续移除该位置的数字，再次进行递归，这次递归表示选择不包含cur位置的数字的所有情况。
     *
     * @param cur
     * @param nums
     */
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
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
