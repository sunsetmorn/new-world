package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution104
 * @description:
 * @date 2023年10月07日
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 提示：
 * 树中节点的数量在 [0, 10000] 区间内。
 * -100 <= Node.val <= 100
 */

public class Solution104 {
    public int maxDepth(TreeNode root) {
        int ret = 0;
        if(root != null){
            ret++;
        }else {
            return ret;
        }
        int left = root.left != null ? maxDepth(root.left) : 0;
        int right = root.right != null ? maxDepth(root.right) : 0;
        return left > right ? ret + left : ret + right;
    }

}
