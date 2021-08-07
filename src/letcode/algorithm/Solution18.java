package letcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class Solution18 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了88.74%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了55.84%的用户
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ret;
        }
        int len = nums.length;
        for(int i =0;i<len-3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for(int j =i+1;j<len-2;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int l2 =j+1,r2=len-1;
                while(l2<r2){
                    int sum =nums[i] + nums[l2] + nums[j]+nums[r2];
                    if(sum == target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l2]);
                        tmp.add(nums[r2]);
                        ret.add(tmp);
                        while (l2<r2 && nums[l2] ==nums[l2+1]) l2++;
                        while (l2<r2 && nums[r2] ==nums[r2-1]) r2--;
                        l2++;
                        r2--;
                    }else if(sum < target){
                        l2++;
                    }else {
                        r2--;
                    }
                }
            }
        }
        List<List<Integer>> tmps = new ArrayList<>();
        for(int i=0;i<ret.size();i++){
            if(!tmps.contains(ret.get(i))){
                tmps.add(ret.get(i));
            }
        }
        return tmps;
    }

    public static void main(String[] args) {
        int[] nums ={1,0,-1,0,-2,2};
        int tar =0;
        List<List<Integer>> ret = fourSum(nums,tar);
        for (List<Integer> l:ret) {
            System.out.print("[");
            for (Integer i:l) {
                System.out.print(i+",");
            }
            System.out.println("]");
        }
    }
}
