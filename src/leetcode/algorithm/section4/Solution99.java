package leetcode.algorithm.section4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Solution99 {
    private static TreeNode treeNode1;
    private static TreeNode treeNode2;
    public static void recoverTree(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Map<Integer,TreeNode> trees = new HashMap<>();
        getTree(root,tree,trees);
        int first = -1;
        for (int i = 0; i < tree.size(); i++) {
            if(i + 1 < tree.size() && tree.get(i) > tree.get(i + 1)){
                first = i;
                break;
            }
        }
        int second = first + 1;
        for (int i = first + 1; i < tree.size(); i++) {
            if(i + 1 < tree.size() && tree.get(i) > tree.get(i + 1)){
                second = i + 1;
                break;
            }
        }
        treeNode1 = trees.get(tree.get(first));
        treeNode2 = trees.get(tree.get(second));
        int tmp = treeNode1.val;
        treeNode1.val = treeNode2.val;
        treeNode2.val = tmp;
    }
    private static void getTree(TreeNode root,List<Integer> list,Map<Integer,TreeNode> trees){
        if(root.left != null){
            getTree(root.left,list,trees);
        }
        list.add(root.val);
        trees.put(root.val,root);
        if(root.right != null){
            getTree(root.right,list,trees);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.right = new TreeNode(2);
        recoverTree(a);
        System.out.println();
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
