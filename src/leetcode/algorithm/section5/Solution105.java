package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution105
 * @description:
 * @date 2023年10月07日
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ret = new TreeNode();

        return null;
    }
}
