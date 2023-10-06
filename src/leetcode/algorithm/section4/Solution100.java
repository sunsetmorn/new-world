package leetcode.algorithm.section4;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10000 <= Node.val <= 10000
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null){
            return false;
        } else if(p.val != q.val){
            return false;
        }
        if(p.left != null && q.left != null){
            if(!isSameTree(p.left,q.left)) return false;
        }else if(!(p.left == null && q.left == null)){
            return  false;
        }
        if(p.right != null && q.right != null){
            if(!isSameTree(p.right,q.right)) return false;
        }else if(!(p.right == null && q.right == null)){
            return  false;
        }
        return true;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
