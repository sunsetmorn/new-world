package leetcode.algorithm.section5;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution116
 * @description:
 * @date 2023年10月16日
 *
 * 给定一个完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 提示：
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 *
 */

public class Solution116 {
    public static Node connect(Node root) {
        connect(new ArrayList<>(),root,0);
        return root;
    }

    private static void connect(List<Node> list,Node root,int height){
        if(root == null) {
            return;
        }else {
            if(list.size() > height){
                root.next = list.get(height);
                list.set(height,root);
            }else {
                root.next = null;
                list.add(root);
            }
        }
        if(root.right != null){
            connect(list,root.right,height + 1);
            connect(list,root.left,height + 1);
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2,new Node(4),new Node(5),null);
        a.right = new Node(3,new Node(6),new Node(7),null);
        connect(a);
        System.out.println(111);
    }
}
