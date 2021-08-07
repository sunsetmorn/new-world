package letcode.algorithm;

import letcode.commen.ListNode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution21 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了52.02%的用户
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2,a);
        ListNode c = new ListNode(1,b);
        ListNode j = new ListNode();
        ListNode k = new ListNode();

        ListNode d = new ListNode(9);
        ListNode e = new ListNode(8,d);
        ListNode f = new ListNode(7,e);
        ListNode r = mergeTwoLists(j,k);
        System.out.println(r);
    }
}
