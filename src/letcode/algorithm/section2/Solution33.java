package letcode.algorithm.section2;

/**
 * 整数数组nums按升序排列，数组中的值互不相同 。
 * 在传递给函数之前，nums在预先未知的某个下标k（0<=k<nums.length）上进行了旋转，
 * 使数组变为[nums[k],nums[k+1],...,nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为?[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回?-1?
 */
public class Solution33 {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(target < nums[0]){
            for(int i=nums.length-1;i>=0;i--){
                if(target > nums[i]){
                    break;
                }else if(target == nums[i]){
                    return i;
                }
            }
        }else{
            for(int i=0;i< nums.length;i++){
                if(target < nums[i]){
                    break;
                }else if(target == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a= new int[]{4,5,6,7,0,1,2};
        int target =0;
        int t = search(a,target);
        System.out.println(t);
    }
}
