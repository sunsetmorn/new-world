package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int max = -10000; //取范围内最小数字
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if(tmp > max){
                max = tmp;
            }
            if(tmp < 0){
                tmp = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-1,9,-1,0,3,-4};
        System.out.println(maxSubArray(a));
    }
}
