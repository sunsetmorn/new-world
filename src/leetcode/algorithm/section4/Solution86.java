package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution86
 * @description:
 * @date 2023年09月15日
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 提示
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Solution86 {

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode small_res = small;
        ListNode big = new ListNode(0);
        ListNode big_res = big;
        ListNode b = head;
        while (b != null) {
            if (b.val < x) {
                small.next = new ListNode(b.val);
                small = small.next;
            } else {
                big.next = new ListNode(b.val);
                big = big.next;
            }
            b = b.next;
        }
        big_res = big_res.next;
        small.next = big_res;
        return small_res.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 7, 9, 2, 3, 10};
        List<ListNode> as = new ArrayList<>();
        for (int i : a) {
            as.add(new ListNode(i));
        }
        ListNode start = new ListNode();
        ListNode tmp = new ListNode();
        for (int i = 0; i < as.size(); i++) {
            if (i == 0) {
                start = as.get(i);
                tmp = start;
            } else {
                tmp.next = as.get(i);
                tmp = tmp.next;
            }
        }
        ListNode partition = partition(start, 5);
        System.out.print(partition.val + ",");
        while (partition.next != null) {
            partition = partition.next;
            System.out.print(partition.val + ",");
        }
    }
}
