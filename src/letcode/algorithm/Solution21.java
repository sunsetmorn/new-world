package letcode.algorithm;

import letcode.commen.ListNode;

/**
 * �ϲ�������������
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 */
public class Solution21 {

    /**
     * ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
     * �ڴ����ģ�37.8 MB, ������ Java �ύ�л�����52.02%���û�
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
