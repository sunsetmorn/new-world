package leetcode.algorithm.section4;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 提示：
 * 1 <= nums.length <= 3 * 10000
 * -10000 <= nums[i] <= 10000
 * nums 已按升序排列
 */
public class Solution80 {
    public static int removeDuplicates(int[] nums) {
        for (int i = nums.length - 1; i > 1; i--) {
            if(nums[i] == nums[i - 2]){
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==  Integer.MAX_VALUE){
                return i;
            }
        }
        return nums.length;
    }

    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] a = {0,1,1,1,2};
        int b = removeDuplicates2(a);
        System.out.println(b);
        for (int i = 0; i < b; i++) {
            System.out.print(a[i]+",");
        }
    }
}
