package leetcode.algorithm.section6;


import leetcode.common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution143
 * @description:
 * @date 2023年12月08日
 * <p>
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 5 * 10000]
 * 1 <= node.val <= 1000
 */

public class Solution143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            list.add(tmp);
        }
        while (list.size() > 0) {
            tmp = list.get(0);
            list.remove(0);
            if (list.size() > 0) {
                ListNode tmp1 = list.get(list.size() - 1);
                tmp.next = tmp1;
                list.remove(list.size() - 1);
                if (list.size() > 0) {
                    tmp1.next = list.get(0);
                } else {
                    tmp1.next = null;
                }
            } else {
                tmp.next = null;
            }
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
        System.out.println(head.val);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
        }
    }


    int i = 0;
    @Test
    public void a(){
        a(i);
    }

    public void a(int i){
        ++i;
        System.out.println( i + "前");
        if(i < 10){
            a(i);
        }
        System.out.println(i + "后");
    }
}
