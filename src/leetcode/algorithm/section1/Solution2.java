package leetcode.algorithm.section1;

import leetcode.common.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode aret = new ListNode(0,ret);
        for(int i =0; i< 100; i++){
            int sum = ret.val + l1.val + l2.val;
            ret.val = sum > 9?sum - 10:sum;
            ret.next = sum > 9?new ListNode(1):new ListNode(0);
            if((l1.next == null) && (l2.next == null)){
                if(ret.next.val == 0)ret.next = null;
                break;
            }else{
                l1 = l1.next != null?l1.next:new ListNode(0);
                l2 = l2.next != null?l2.next:new ListNode(0);
                ret = ret.next;
            }
        }
        return aret.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6,new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1,l2);
        for(int i =0;i<100;i++){
            System.out.println(l3.val);
            if(l3.next != null){
                l3 = l3.next;
            }else{
                break;
            }
        }
    }

}
