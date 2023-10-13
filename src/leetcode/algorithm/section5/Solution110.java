package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution110
 * @description:
 * @date 2023年10月13日
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 */

public class Solution110 {
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(height(root) > 0) return true;
        return false;
    }

    private static int height(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left < 0 || right < 0 || (Math.abs(left - right) > 1)){
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        System.out.println(isBalanced(a));
    }
}
