package leetcode.algorithm.section4;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 你必须尽可能减少整个操作步骤。
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -10000 <= nums[i] <= 10000
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10000 <= target <= 10000
 */
public class Solution81 {
    public static boolean search(int[] nums, int target) {
        if(target > nums[0]){
            for (int i = 1; i < nums.length; i++) {
                if(target == nums[i]) return true;
                if(nums[i] < nums[i - 1]) return false;
            }
        }else if(target == nums[0]){
            return true;
        }else {
            for (int i = nums.length - 1; i > 0; i--) {
                if(target == nums[i]) return true;
                if(i + 1 < nums.length && nums[i] > nums[i + 1]) return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,5,6,0,0,1,2};
        System.out.println(search(a, 8));
    }
}
