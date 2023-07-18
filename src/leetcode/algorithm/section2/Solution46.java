package leetcode.algorithm.section2;

import java.util.ArrayList;

import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列。你可以按任意顺序返回答案。
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++){
            if(i == 0){
                list.add(nums[0]);
                retList.add(list);
            }else{
                retList = addOne(retList,nums[i]);
            }
        }
        return retList;
    }

    private static List<List<Integer>> addOne(List<List<Integer>> lists,Integer in){
        List<List<Integer>> retList= new ArrayList<>();
        for (List<Integer> list : lists) {
            for (int i = 0; i <= list.size() ; i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                tmp.add(i,in);
                retList.add(tmp);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
    }


    /**
     * 最快算法
     * 通过交换位置实现
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, int[] A, int k) {
        if (list.size() == A.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=k; i<A.length; i++) {
            swap(A, i, k);
            list.add(A[k]);
            dfs(result, list, A, k+1);
            list.remove(list.size()-1);
            swap(A, i, k);
        }
    }
    private void swap(int[] A, int p, int q) {
        int tmp = A[p];
        A[p] = A[q];
        A[q] = tmp;
    }
}
