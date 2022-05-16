package leetcode.algorithm.section1;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Solution16 {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了72.44%的用户
     * 内存消耗：7.7 MB, 在所有 Java 提交中击败了96.63%的用户
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret =Integer.MAX_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int l = i+1, r =len -1;
            while(l<r){
                int tmp = nums[i] + nums[l] + nums[r];
                if(tmp > target){
                    if(Math.abs(tmp-target) < Math.abs(ret-target)){
                        ret =tmp;
                    }
                    r--;
                }else if (tmp == target){
                    return tmp;
                }else{
                    if(Math.abs(target-tmp) < Math.abs(ret-target)){
                        ret =tmp;
                    }
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,5,7};
        int b =13;
        System.out.println(threeSumClosest(a,b));
    }
}
