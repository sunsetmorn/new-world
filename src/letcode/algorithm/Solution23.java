package letcode.algorithm;

import letcode.commen.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * �ϲ�K����������
 * ����һ���������飬ÿ�������Ѿ����������С�
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 */
public class Solution23 {
    /**
     * leetcode��촦����
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    //���ַ�
    private static ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = (right - left)/2 + left;
        //��lists�ֳ������֣��ֱ�������������Ⱥϲ��ã�Ȼ���ٰ��պϲ����������������õ����Ľ��
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * ʹ������������ȡ��������½��ķ���
     * ִ����ʱ��8 ms, ������ Java �ύ�л�����37.22%���û�
     * �ڴ����ģ�39.7 MB, ������ Java �ύ�л�����90.14%���û�
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length ==0) return null;
        ListNode ret = new ListNode();
        List<Integer> s= new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode tmp = lists[i];
            while(tmp != null){
                s.add(tmp.val);
                tmp = tmp.next;
            }
        }
        s.sort(Integer::compareTo);
        if(s.size() ==0) return null;
        ListNode pointer = ret;
        for(int i =0;i<s.size();i++){
            pointer.val = s.get(i);
            if(i+1<s.size()){
                pointer.next = new ListNode();
                pointer = pointer.next;
            }
        }

        return ret;
    }


    /**
     * ʹ��������ӵķ���
     * ִ����ʱ��108 ms, ������ Java �ύ�л�����26.75%���û�
     * �ڴ����ģ�40.2 MB, ������ Java �ύ�л�����37.48%���û�
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length ==0 ) return null;
        ListNode ret = lists[0];
        for (int i=1 ;i<lists.length;i++) {
            ret = mergeTwoLists(ret,lists[i]);
        }
        return ret;
    }
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
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(1,b);

        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3,d);
        ListNode f = new ListNode(1,e);

        ListNode g = new ListNode(6);
        ListNode h = new ListNode(2,g);
        ListNode[] l = {c,f,h};
        ListNode ret= mergeKLists(l);
        System.out.println(ret);
    }
}
