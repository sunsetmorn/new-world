package leetcode.algorithm.section3;

/**
 * 给定一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 1 <= nums.length <= 3 * 10000
 * 0 <= nums[i] <= 100000
 */

public class Solution55 {
    public static boolean canJump(int[] nums) {
        int goal = nums.length -1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= goal) goal = i;
            if(goal == 0) return true;
        }
        return false;
    }
}
