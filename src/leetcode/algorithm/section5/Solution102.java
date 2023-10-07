package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution102
 * @description:
 * @date 2023年10月07日
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */

public class Solution102 {
    private List<List<Integer>> ret;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<>();
        levelOrder(root,0);
        return ret;
    }
    private void levelOrder(TreeNode root,int num){
        if(root != null){
            if(ret.size() <= num){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                ret.add(tmp);
            }else {
                List<Integer> list = ret.get(num);
                list.add(root.val);
            }
        }else {
            return;
        }
        if(root.left != null){
            levelOrder(root.left,num + 1);
        }
        if(root.right != null){
            levelOrder(root.right,num + 1);
        }
    }
}
