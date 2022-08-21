package leetcode.algorithm.section2;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 */
public class Solution31 {
    /**
     * 思路：从最后一位向第一位开始循环，每次找后续位置的数字中的比该数大的最小数，没有则继续向前，
     * 若找到了则交换位置，并将后面的数进行从小到大排序，并直接退出。
     * 因为这个规律，该位置后面的数一定是倒叙排列的（从大到小，否则会提前结束循环），所有找最小的数只需要从最后一位开始
     * 如果一直没找到则把所有的数从小到大排序。
     */
    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length<1) return;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    changeNum(nums,i,j);
                    sortNum(nums,i+1);
                    return;
                }
            }
        }
        sortNum(nums,0);
    }

    public static void changeNum(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void sortNum(int[] nums,int a){
        for(int i=nums.length-1;i>a;i--){
            for (int j=a;j<i;j++){
                if(nums[j] > nums[i]){
                    changeNum(nums,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]= {1,2,1,0};
        nextPermutation(a);
        System.out.println("11111"+a);

    }
}
