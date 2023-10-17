package leetcode.algorithm.section5;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution117
 * @description:
 * @date 2023年10月17日
 *
 * 给定一个二叉树：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 */

public class Solution117 {
    public Node connect(Node root) {
        connect(new ArrayList<>(),root,0);
        return root;
    }

    private void connect(List<Node> list, Node root, int height){
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
        }
        if(root.left != null){
            connect(list,root.left,height + 1);
        }
    }
}
