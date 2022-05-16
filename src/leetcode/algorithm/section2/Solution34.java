package leetcode.algorithm.section2;

/**
 *  给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值target，返回?[-1, -1]。
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0 || target > nums[nums.length-1] || target < nums[0]){
            return new int[]{-1, -1};
        }
        int start = -1;
        int end = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(target < nums[i]){
                break;
            }else if(target == nums[i]){
                end = i;
                if(start == -1){
                    start = i;
                }
            }
        }
        return new int[]{start, end};
    }
}
