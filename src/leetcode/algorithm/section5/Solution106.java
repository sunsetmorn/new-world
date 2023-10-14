package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution106
 * @description:
 * @date 2023年10月09日
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 提示：
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 */

public  class Solution106 {

    // 指针，记录preorder的位置
    private static int post = 0;
    // 指针，记录inorder的位置
    private static int in = 0;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return recursive(inorder,postorder,Integer.MAX_VALUE);
    }

    public static TreeNode recursive(int[] inorder, int[] postorder,int stop) {
        // pre指针越界，返回null
        if (post < 0) return null;
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int curValue = postorder[post--];
        TreeNode cur = new TreeNode(curValue);
        cur.right = recursive(inorder,postorder,curValue);
        cur.left = recursive(inorder,postorder,stop);
        return cur;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post  = {9,15,7,20,3};
        TreeNode treeNode = buildTree(in, post);
        System.out.println(treeNode);
    }

}
