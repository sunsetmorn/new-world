package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode flatLeft;
        if (left == null) {
            flatLeft = root;
        } else {
            root.left = null;
            flatLeft = flat(left);
            root.right = left;
        }
        TreeNode flatRight;
        if (right == null) {
            flatRight = flatLeft;
        } else {
            flatRight = flat(right);
            flatLeft.right = right;
        }
        return flatRight;
    }
}
