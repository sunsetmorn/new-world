package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution113 {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ret;
        getSum(new ArrayList<>(), root, targetSum);
        return ret;
    }

    private void getSum(List<Integer> list, TreeNode root, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ret.add(new ArrayList<>(list));
            }
        } else {
            getSum(list,root.left,targetSum - root.val);
            getSum(list,root.right,targetSum - root.val);
        }
        list.remove(list.size() - 1);
    }
}
