package leetcode.algorithm.section4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 提示：
 * 1 <= heights.length <=100000
 * 0 <= heights[i] <= 10000
 */
public class Solution84 {

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    //超时
    public static int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int len = 1;
            if (i > 0) {
                if (heights[i] > heights[i - 1]) {
                    for (int j = i + 1; j < heights.length; j++) {
                        if (heights[j] >= heights[i]) {
                            len++;
                        } else {
                            break;
                        }
                    }
                } else if (heights[i] < heights[i - 1]) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (heights[j] >= heights[i]) {
                            len++;
                        } else {
                            break;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                for (int j = i + 1; j < heights.length; j++) {
                    if (heights[j] >= heights[i]) {
                        len++;
                    } else {
                        break;
                    }
                }
            }
            max = Math.max(max, len * heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 2};
        System.out.println(largestRectangleArea(a));
    }

}
