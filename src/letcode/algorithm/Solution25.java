package letcode.algorithm;

import letcode.commen.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * K个一组翻转链表
 * 给你一个链表，每?k?个节点一组进行翻转，请你返回翻转后的链表。
 * k?是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是?k?的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution25 {

    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode pointer = head;
        List<ListNode> li = new ArrayList<>();
        while(pointer!=null){
            li.add(pointer);
            pointer = pointer.next;
        }
        if(li.size() == 0){
            return null;
        }else if(li.size() < k){
            return head;
        }
        for(int i=0;i<li.size()/k;i++){
            
        }

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了29.84%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了41.57%的用户
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        int len = 0;
        ListNode pointer = head;
        while(pointer!=null){
            len++;
            pointer = pointer.next;
        }
        if(len==0){
            return null;
        }else if(len < k){
            return head;
        }
        ListNode ret = new ListNode(0,head);
        pointer= ret;
        for(int i=0;i<len/k;i++){
            pointer = reverseNextKGroup(pointer,k);
        }
        return ret.next;
    }
    public static ListNode reverseNextKGroup(ListNode head, int k){
        List<ListNode> li = new ArrayList<>();
        ListNode pointer = head.next;
        for(int i=0;i<k;i++){
            li.add(pointer);
            pointer=pointer.next;
        }
        ListNode tmp = head;
        for(int i=k-1;i>=0;i--){
            tmp.next = li.get(i);
            tmp=tmp.next;
        }
        tmp.next = pointer;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(5,a);
        ListNode c = new ListNode(4,b);
        ListNode d = new ListNode(3,c);
        ListNode e = new ListNode(2,d);
        ListNode f = new ListNode(1,e);
        ListNode g = null;

        ListNode aa = reverseKGroup(g,3);
        System.out.println(aa);
    }
}
