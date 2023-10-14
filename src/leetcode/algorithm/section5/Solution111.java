package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution11
 * @description:
 * @date 2023年10月13日
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 提示：
 * 树中节点数的范围在 [0, 100000] 内
 * -1000 <= Node.val <= 1000
 */

public class Solution111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null)
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
