package letcode.algorithm.section1;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        asFor: for (int i =0;i<nums.length;i++) {
            for(int j =0;j<i;j++){
                if(nums[i] + nums[j] == target){
                    ret[0] =i;
                    ret[1] =j;
                    break asFor;
                }
            }
        }
        return ret;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>();
        for (int i =0;i< nums.length;i++) {
            if(map.containsKey(nums[i])){
                return new int[]{(int)map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] =3;
        a[1] =2;
        a[2] =3;
        int target = 6;
        int[] b = twoSum(a,target);
        System.out.println(b[0] + "," +b[1]);
    }
}
