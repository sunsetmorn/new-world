package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution94
 * @description:
 * @date 2023年09月22日
 */

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root != null) inOrder(root,ret);
        return ret;
    }
    public void inOrder(TreeNode root,List<Integer> list){
        if(root.left != null){
            inOrder(root.left,list);
        }
        list.add(root.val);
        if(root.right != null){
            inOrder(root.right,list);
        }
    }

}
