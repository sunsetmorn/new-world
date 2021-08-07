package letcode.algorithm;

import letcode.commen.ListNode;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution24 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了60.50%的用户
     */
    public static ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode ret = new ListNode(0,head);
        ListNode pointer = ret;
        while(pointer.next !=null){
            if(pointer.next.next !=null){
                ListNode tmp1 =pointer.next;
                ListNode tmp2 =tmp1.next;
                tmp1.next = tmp2.next;
                tmp2.next = tmp1;
                pointer.next = tmp2;
                pointer = pointer.next.next;
            }else {
                break;
            }
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(1,b);
        ListNode d = null;

        ListNode e = swapPairs(d);
        System.out.println(e);
    }
}
