package leetcode.algorithm.section4;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode root = new ListNode();
        root.next = head;
        ListNode tmp1 = root,tmp3;
        while (head.next != null){
            tmp3 = head.next;
            if(head.val == tmp3.val){
                if(tmp3.next != null){
                    tmp1.next = tmp3.next;
                    head = tmp3;
                }else{
                    tmp1.next = null;
                    head = tmp3;
                }
            }else {
                if(head == tmp1.next){
                    tmp1 = tmp1.next;
                }
                head = tmp1.next;
            }
        }
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        int[] b = {};
        ListNode tmp = a;
        for (int i = 0; i < b.length; i++) {
            if(tmp.val == 0){
                tmp.val = b[i];
            }else {
                tmp.next = new ListNode(b[i]);
                tmp = tmp.next;
            }
        }
        ListNode listNode = deleteDuplicates(null);
        System.out.println(listNode.val);
        while (listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
