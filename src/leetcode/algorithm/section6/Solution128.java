package leetcode.algorithm.section6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaoxq
 * @ClassName Solution128
 * @description:
 * @date 2023年10月27日
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 提示：
 *
 * 0 <= nums.length <= 10000
 * -1000000000 <= nums[i] <= 1000000000
 */

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int ret = 0;
        if (nums.length == 0) return ret;
        Arrays.sort(nums);
        int tmp = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) continue;
            if(nums[i] == ++tmp){
                len++;
            }else {
                tmp = nums[i];
                ret = Math.max(ret,len);
                len = 1;
            }
        }
        return Math.max(ret,len);
    }

    @Test
    public void test(){
        int[] a = {1,2,0,1};
        longestConsecutive(a);
    }
}
