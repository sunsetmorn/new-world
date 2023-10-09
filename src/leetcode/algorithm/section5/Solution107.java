package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution107
 * @description:
 * @date 2023年10月09日
 *
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 */

public class Solution107 {
    private List<List<Integer>> ret;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ret = new ArrayList<>();
        levelOrderBottom(root,0);
        return ret;
    }

    private void levelOrderBottom(TreeNode root,int num){
        if(root != null){
            if(ret.size() <= num){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                ret.add(0,tmp);
            }else {
                List<Integer> list = ret.get(ret.size() - num - 1);
                list.add(root.val);
            }
        }else {
            return;
        }
        if(root.left != null){
            levelOrderBottom(root.left,num + 1);
        }
        if(root.right != null){
            levelOrderBottom(root.right,num + 1);
        }
    }

}
