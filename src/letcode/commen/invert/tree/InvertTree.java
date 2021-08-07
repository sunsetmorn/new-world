package letcode.commen.invert.tree;

import letcode.commen.TreeNode;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(9);
        b.left =a;
        b.right =c;
        d.left =b;
        d.right =f;
        f.right =g;
        f.left =e;

        TreeNode k = invertTree(d);
        System.out.println("21416531321");

    }

    public static TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left ==null && root.right ==null)){
            return root;
        }
        //翻转左子树
        TreeNode left = invertTree(root.left);
        //翻转右子树
        TreeNode right= invertTree(root.right);
        //左右子树交换位置~
        root.left = right;
        root.right = left;
        return root;
    }
}
