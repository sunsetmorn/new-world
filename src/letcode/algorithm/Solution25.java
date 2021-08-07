package letcode.algorithm;

import letcode.commen.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * K��һ�鷭ת����
 * ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������
 * k?��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * ���ף�
 * ��������һ��ֻʹ�ó�������ռ���㷨�������������
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
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
     * ִ����ʱ��1 ms, ������ Java �ύ�л�����29.84%���û�
     * �ڴ����ģ�38.7 MB, ������ Java �ύ�л�����41.57%���û�
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
