package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution124
 * @description:
 * @date 2023年10月20日
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 提示：
 * 树中节点数目范围是 [1, 3 * 10000]
 * -1000 <= Node.val <= 1000
 */

public class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root){
        if(root != null){
            int left = getMax(root.left);
            int right = getMax(root.right);
            
            int tmp = root.val;
            int sum = root.val;
            if(left >= 0 || right >= 0){
                tmp += Math.max(left, right);
            }
            if(left >= 0){
                sum += left;
            }
            if(right >= 0){
                sum += right;
            }
            max = Math.max(sum, max);
            return tmp;
        }else {
            return 0;
        }
    }
}
