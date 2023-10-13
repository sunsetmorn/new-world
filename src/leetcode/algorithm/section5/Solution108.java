package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution108
 * @description:
 * @date 2023年10月10日
 *
 *给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 */

public class Solution108 {
    private static int[] arrays;
    public static TreeNode sortedArrayToBST(int[] nums) {
        arrays = nums;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode ret = new TreeNode(nums[nums.length / 2]);
        ret.left = sortedArrayToBST(0,nums.length / 2 - 1);
        ret.right = sortedArrayToBST(nums.length / 2 + 1,nums.length - 1);
        return ret;
    }

    private static TreeNode sortedArrayToBST(int start,int end){
        if (start == end){
            return new TreeNode(arrays[end]);
        }else if(start > end){
            return null;
        }
        TreeNode ret = new TreeNode(arrays[(start + end) / 2]);
        ret.left = sortedArrayToBST(start,(start + end) / 2 - 1);
        ret.right = sortedArrayToBST((start + end) / 2 + 1,end);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
