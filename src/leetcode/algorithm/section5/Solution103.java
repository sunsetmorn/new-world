package leetcode.algorithm.section5;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * @author zhaoxq
 * @ClassName Solution103
 * @description:
 * @date 2023年10月07日
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 */

public class Solution103 {
    private List<List<Integer>> ret;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ret = new ArrayList<>();
        zigzagLevelOrder(root,0);
        for (int i = 0; i < ret.size(); i++) {
            if(i % 2 == 1){
                Collections.reverse(ret.get(i));
            }
        }

        return ret;
    }
    private void zigzagLevelOrder(TreeNode root,int num){
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
            zigzagLevelOrder(root.left,num + 1);
        }
        if(root.right != null){
            zigzagLevelOrder(root.right,num + 1);
        }
    }
}
