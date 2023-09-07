package leetcode.algorithm.section3;


/**
 * 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int i = 1;
        ListNode listNode = head;
        while (listNode.next != null){
            listNode = listNode.next;
            i++;
        }
        listNode.next = head;
        if(k > i) k %= i;
        for (int j = 0; j < i - k; j++) {
            listNode = listNode.next;
        }
        head = listNode.next;
        listNode.next = null;
        return head;
    }


//     Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
