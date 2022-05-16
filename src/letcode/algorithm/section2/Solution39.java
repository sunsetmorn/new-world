package letcode.algorithm.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个无重复元素的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target的不同组合数少于 150 个。
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length ==0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> retList = new ArrayList();
        for(int i=0;i<candidates.length;i++){
            List<Integer> tmp = new ArrayList();
            int sum=0;
            addSum(candidates,target,tmp,0,sum,retList);
        }
        return retList;
    }

    public static void addSum(int[] candidates, int target, List<Integer> ints,int flag,int sum,List<List<Integer>> ret){
        if(sum+candidates[flag] < target){
            addSum(candidates,target,ints,flag,sum+candidates[flag],ret);
        }else if (sum+candidates[flag] == target){
            ints.add(candidates[flag]);
            ret.add(ints);
            if(flag > 1) {
                addSum(candidates, target, ints, flag - 1, sum + candidates[flag], ret);
            }
        } else if(sum+candidates[flag] > target){
            if(flag > 1){
                addSum(candidates,target,ints,flag-1,sum+candidates[flag],ret);
            }
        }
    }
}
