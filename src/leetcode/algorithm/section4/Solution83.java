package leetcode.algorithm.section4;

import leetcode.common.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode tmp1 = head;
        while (tmp1.next != null){
            if(tmp1.val == tmp1.next.val){
                tmp1.next = tmp1.next.next;
            }else {
                tmp1 = tmp1.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        int[] b = {1,1,2};
        ListNode tmp = a;
        for (int i = 0; i < b.length; i++) {
            if(tmp.val == 0){
                tmp.val = b[i];
            }else {
                tmp.next = new ListNode(b[i]);
                tmp = tmp.next;
            }
        }
        ListNode listNode = deleteDuplicates(a);
        System.out.println(listNode.val);
        while (listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
