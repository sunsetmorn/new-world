package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

/**
 * @author zhaoxq
 * @ClassName Solution101
 * @description:
 * @date 2023年10月07日
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null) {
            return true;
        }else {
            if(left == null || right == null || left.val !=  right.val){
                return false;
            }else {
                return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
            }
        }

    }
}
