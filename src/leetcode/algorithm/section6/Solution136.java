package leetcode.algorithm.section6;

import org.junit.Test;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 10000
 * -3 * 10000 <= nums[i] <= 3 * 10000
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if(i + 1 >= nums.length || nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;

    }

    @Test
    public void test(){
        int[] a= {4,1,2,1,2};
        System.out.println(singleNumber2(a));
    }
}
