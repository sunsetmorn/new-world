package leetcode.algorithm.section6;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxq
 * @ClassName Solution147
 * @description: 对链表进行插入排序
 * @date 2024年02月23日
 *
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 插入排序 算法的步骤:
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 *
 * 提示：
 * 列表中的节点数在 [1, 5000]范围内
 * -5000 <= Node.val <= 5000
 */

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}