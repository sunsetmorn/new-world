package leetcode.algorithm.section6;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution129
 * @description:
 * @date 2023年10月27日
 * <p>
 * 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */

public class Solution129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        get(root,0);
        return sum;
    }

    private void get(TreeNode root, int val) {
        int t = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += t;
            return;
        }
        if(root.left != null){
            get(root.left, t);
        }
        if(root.right != null){
            get(root.right, t);
        }
    }
}
