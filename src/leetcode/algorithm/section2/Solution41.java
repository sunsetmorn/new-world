package leetcode.algorithm.section2;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  1 <= nums.length <= 5 * 105
 *  -2^31 <= nums[i] <= 2^31 - 1
 */
public class Solution41 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ;  i++){
            if(nums[i] <= 1) continue;
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            if(i >= 1 && nums[i] != nums[i-1] + 1 ){
                return nums[i-1] + 1 > 0 ? nums[i-1] + 1 : 1;
            }
            if(i == 0 && nums[i] > 1){
                return 1;
            }
        }
        return  nums[nums.length-1] + 1 > 0 ? nums[nums.length-1] + 1 : 1;
    }


    /**
     * leetcode 最短时间算法
     * 说明：
     *  以排序成[1,2,3,4,5,6...]的目标最计算。定义当前位置，最大有效位置对应数字。
     *  按位置判断数字是否符合，符合则当前位置+1，
     *  不符合时，小于要求数字的数、大于最后一位的有效数字的 换到最后一位有效数，最后一位有效位置减少一。
     *  若是中间某个位置对应的数则直接换到该位置，当该位置已经有数时，则同样换到数末尾。
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int L = 0;
        int R = nums.length;
        while (L < R) {
            if (nums[L] == L + 1) {
                L++;
            } else if (nums[L] <= L || nums[L] > R || nums[nums[L] - 1] == nums[L]) {
                swap(nums, L, --R);
            } else {
                swap(nums, L, nums[L] - 1);
            }
        }
        return L + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
