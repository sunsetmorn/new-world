package letcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 三数之和
 * 给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，
 * 使得?a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class Solution15 {
    /**
     *
     * 执行用时：17 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了29.55%的用户
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int len =nums.length;
        for(int i=0;i<len;i++){
            int tmp =nums[i];
            if(tmp > 0) return ret;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = len-1;
            while (l<r){
                if(tmp+nums[l]+nums[r] == 0){
                    List<Integer> tmps = new ArrayList<>();
                    tmps.add(tmp);
                    tmps.add(nums[l]);
                    tmps.add(nums[r]);
                    ret.add(tmps);
                    while (l<r && nums[l] ==nums[l+1]) l++;
                    while (l<r && nums[r] ==nums[r-1]) r--;
                    l++;
                    r--;
                }else if (tmp+nums[l]+nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> ret = threeSum(nums);
        for (List<Integer> i:ret) {
            System.out.print("[");
            for (Integer j:i) {
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println("]");
        }

    }
}
