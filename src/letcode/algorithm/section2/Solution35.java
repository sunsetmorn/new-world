package letcode.algorithm.section2;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0 ){
            return 0;
        }
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length-1]< target){
            return nums.length;
        }

        return dichotomy(nums,0,nums.length-1,target);
    }

    public static int dichotomy(int[] nums,int start,int end,int target){
        if(start >= end){
            if(nums[start] >= target){
                return start;
            }else {
                return start+1;
            }
        }
        int med = (start+end)/2;
        if(nums[med]== target){
            return med;
        }else if(nums[med] > target){
            return dichotomy(nums,start,med-1,target);
        }else{
            return dichotomy(nums,med+1,end,target);
        }
    }

    public static void main(String[] args) {
        int[] a = {3,5,7,9,10};
        int b =8;
        System.out.println(searchInsert(a, b));
    }
}
