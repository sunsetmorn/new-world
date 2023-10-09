package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution105
 * @description:
 * @date 2023年10月07日
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
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

    private static int pre = 0;// 指针，记录preorder的位置
    private static int in = 0;// 指针，记录inorder的位置
    private static int[] preorder, inorder;

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Solution105.preorder = preorder;
        Solution105.inorder = inorder;
        return recursive(Integer.MAX_VALUE);
    }

    public static TreeNode recursive(int stop) {
        if (pre >= preorder.length) return null;// pre指针越界，返回null
        if (inorder[in] == stop) {// stop等于inorder某次循环的最大值
            in++;// inorder指针往下走
            return null;// stop相当于一颗分支树的root点，或者边界，触碰到就，返回null，回到上面继续循环
        }
        int curValue = preorder[pre++];// 相当于用pre指针递归遍历preorder
        TreeNode cur = new TreeNode(curValue);// 用指针指向的当前preorder位置的值建节点
        cur.left = recursive(curValue);// 左孩子树的边界，是inorder的curValue值，一直循环到if(inorder[in]==stop)的地方。
        cur.right = recursive(stop);// 右孩子树没有边界，pre走完就走完了
        return cur;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ret = new TreeNode();
        if (preorder.length != 0) {
            ret.val = preorder[0];
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] != preorder[0]) {
                    if (flag) {
                        right.add(inorder[i]);
                    } else {
                        left.add(inorder[i]);
                    }
                } else {
                    flag = true;
                }
            }
            int[] pre = new int[left.size()];
            int[] in = new int[left.size()];
            for (int i = 0; i < left.size(); i++) {
                in[i] = left.get(i);
                pre[i] = preorder[i + 1];
            }
            ret.left = buildTree(pre, in);
            int[] pre2 = new int[right.size()];
            int[] in2 = new int[right.size()];
            for (int i = 0; i < right.size(); i++) {
                in2[i] = right.get(i);
                pre2[i] = preorder[i + left.size() + 1];
            }
            ret.right = buildTree(pre2, in2);
        } else {
            return null;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        buildTree2(a, b);
    }
}
