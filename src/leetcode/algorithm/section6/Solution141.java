package leetcode.algorithm.section6;

import leetcode.common.ListNode;

/**
 * @author zhaoxq
 * @ClassName Solution141
 * @description:
 * @date 2023年12月08日
 * <p>
 * 141 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 10000]
 * -100000 <= Node.val <= 100000
 * pos 为 -1 或者链表中的一个 有效索引 。
 */

public class Solution141 {
    /**
     * 快慢指针，如果能重合说明有环
     * 证明：
     * 设 步骤数为n,快指针走过距离为2n，慢指针走过距离为n，
     * 在有环的情况下，设环长度为k，设环之前的长度为m
     * 若k > m，当n = k等于环的长度时,慢指针走过k，入环后走过k - m步，快指针走过2k，入环后走过2k - m步，因k > m，所以快指针比慢指针多走过一圈，停在相同的位置。
     * 若k < m，设最小整数t，t * k > m，当n = t*k时，慢指针走过t*k步，入环后走t*k-m步，快指针入环后走t*k-m+t*k步，除去绕了t圈，快指针和慢指针停在同一位置。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
