package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution92
 * @description:
 * @date 2023年09月21日
 */

import leetcode.common.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 */
public class Solution92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode tmp1 = head;
        ListNode ret = new ListNode();
        ListNode tmp2 = new ListNode();
        ListNode tmp3 = new ListNode();
        ListNode tmp4 = new ListNode();
        for (int i = 1; i <= right; i++){
            if(i > 0 && i + 1 == left){
                ret.next = head;
                tmp2 = tmp1;
            }else if(1 == left){
                ret = tmp2;
            }
            if(i == left){
                ListNode tmp = new ListNode(tmp1.val);
                tmp4 = tmp;
                tmp3 = tmp;
            }else if(i > left){
                ListNode tmp = new ListNode(tmp1.val);
                tmp.next = tmp3;
                tmp3 = tmp;
            }
            if(i == right){
                tmp2.next = tmp3;
                tmp4.next = tmp1.next;
            }
            tmp1 = tmp1.next;
        }
        return ret.next;
    }


    public static void main(String[] args) {
        int[] a= {1,2,3,4,5};
        ListNode l = new ListNode();
        ListNode tmp = l;
        for (int i = 0; i < a.length; i++) {
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        ListNode listNode = reverseBetween(l.next, 2, 4);
        System.out.print(listNode.val + ",");
        while(listNode.next != null){
            listNode = listNode.next;
            System.out.print(listNode.val + ",");
        }
    }

}



