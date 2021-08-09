package letcode.algorithm.section2;

/**
 *  删除有序数组中的重复项
 *  给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution26 {

    /**
     * lertcode最短时间
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了90.49%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了68.30%的用户
     */
    public static int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length==0) return 0;
        int n=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[n]){
                nums[++n] = nums[i];
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] a = null;
        int b =removeDuplicates(a);
        System.out.println(b);
    }
}
