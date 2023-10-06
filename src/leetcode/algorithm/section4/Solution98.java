package leetcode.algorithm.section4;

import leetcode.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 提示：
 * 树中节点数目范围在[1, 10000] 内
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Solution98 {
    public static boolean isValidBST(TreeNode root) {
        if(root.left != null) {
            if(root.left.val >= root.val || !isValidBST(root.left,Long.MIN_VALUE,root.val)){
                return false;
            }
        }
        if(root.right != null) {
            if(root.right.val <= root.val || !isValidBST(root.right,root.val,Long.MAX_VALUE)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root,long min,long max) {
        if(root.left != null) {
            if(root.left.val >= root.val || root.left.val <= min || root.left.val >= max || !isValidBST(root.left,min,root.val)){
                return false;
            }
        }
        if(root.right != null) {
            if(root.right.val <= root.val || root.right.val <= min || root.right.val >= max || !isValidBST(root.right,root.val,max)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(1,new TreeNode(0), new TreeNode(2,null,new TreeNode(3)));
        a.right = new TreeNode(5,new TreeNode(4), new TreeNode(6));
        System.out.println(isValidBST(a));
    }
}
