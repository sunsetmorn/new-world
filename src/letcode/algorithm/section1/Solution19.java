package letcode.algorithm.section1;

import letcode.commen.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Solution19 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了35.35%的用户
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0,head);
        ListNode tmp2 = head;
        int t= 1;
        while(tmp2.next !=null){
            tmp2 =tmp2.next;
            t++;
            if(t>n){
                tmp =tmp.next;
            }
        }
        if(t>n){
            tmp.next = tmp.next.next;
        }else if (t==n){
            return head.next;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(5,a);
        ListNode c = new ListNode(4,b);
        ListNode d = new ListNode(3,c);
        ListNode e = new ListNode(2,d);
        ListNode f = new ListNode(1);
        ListNode g = removeNthFromEnd(f,1);
        System.out.println(g.val);
        System.out.println(111);
    }
}
