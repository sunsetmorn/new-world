package leetcode.algorithm.section6;

import leetcode.common.ListNode;

/**
 * @author zhaoxq
 * @ClassName Solution142
 * @description:
 * @date 2023年12月08日
 * 142 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * 提示：
 * 链表中节点的数目范围在范围 [0, 10000] 内
 * -100000 <= Node.val <= 100000
 * pos 的值为 -1 或者链表中的一个有效索引
 */

public class Solution142 {

    /**
     * 快慢指针，快慢指针重合后，快指针复位，快慢指针均变成慢指针，再次重合后为入环节点。
     * 设 步骤数为n,快指针走过距离为2n，慢指针走过距离为n，
     * 在有环的情况下，设环长度为k，设环之前的长度为m
     * 第一次快慢指针重合时n是比m大的k的最小倍数。设倍数为t。位置为t * k - m ，t >= 1.
     * 快指针回到起点，两个指针再同时走过 m步，快指针走过m，慢指针共走过t*k + m步，除去绕行的t圈，两指针均停在m处。即入环位置。
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
