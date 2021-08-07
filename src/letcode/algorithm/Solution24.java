package letcode.algorithm;

import letcode.commen.ListNode;

/**
 * �������������еĽڵ�
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 */
public class Solution24 {
    /**
     * ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
     * �ڴ����ģ�36 MB, ������ Java �ύ�л�����60.50%���û�
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
