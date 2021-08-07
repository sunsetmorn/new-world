package letcode.algorithm;

import letcode.commen.ListNode;

/**
 * ɾ������ĵ����� N �����
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 */
public class Solution19 {
    /**
     * ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
     * �ڴ����ģ�36.5 MB, ������ Java �ύ�л�����35.35%���û�
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
