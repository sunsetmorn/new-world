package leetcode.algorithm.section5;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution109
 * @description:
 * @date 2023年10月13日
 *
 * 给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 *
 * 提示:
 * head 中的节点数在[0, 2 * 10000] 范围内
 * -100000 <= Node.val <= 100000
 */

public class Solution109 {
    static List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        list.add(head.val);
        while (head.next != null){
            head = head.next;
            list.add(head.val);
        }
        TreeNode ret = new TreeNode(list.get(list.size() / 2));
        ret.left = sortedArrayToBST(0,list.size() / 2 - 1);
        ret.right = sortedArrayToBST(list.size() / 2 + 1,list.size() - 1);
        return ret;
    }

    private TreeNode sortedArrayToBST(int start,int end){
        if (start == end){
            return new TreeNode(list.get(end));
        }else if(start > end){
            return null;
        }
        TreeNode ret = new TreeNode(list.get((start + end) / 2));
        ret.left = sortedArrayToBST(start,(start + end) / 2 - 1);
        ret.right = sortedArrayToBST((start + end) / 2 + 1,end);
        return ret;
    }

    ListNode globalHead;

    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }
    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }
    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
