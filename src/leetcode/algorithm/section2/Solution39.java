package leetcode.algorithm.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个无重复元素的整数数组candidates和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字被的选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target的不同组合数少于150个。
 */
public class Solution39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length ==0) return null;
        Arrays.sort(candidates);
        if(candidates[0] <= 0) return null;

        List<List<Integer>> retList = new ArrayList();
        List<Integer> start = new ArrayList<>();
        addSum(candidates,target,start,retList,0);
        return retList;
    }

    public static void addSum(int[] candidates, int remains, List<Integer> ints,List<List<Integer>> retList,int flag){
        for(int i = flag; i < candidates.length;i++){
            if(candidates[i] < remains){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(ints);
                tmp.add(candidates[i]);
                addSum(candidates,remains-candidates[i],tmp,retList,i);
            }else if (candidates[i] == remains){
                ints.add(candidates[i]);
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(ints);
                retList.add(tmp);
                break;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int target =7;
        List<List<Integer>> lists = combinationSum(a, target);
        System.out.println();
    }

    /**
     * leetcode最快方案
     * 比上面方案优化过
     */
    class leetCode{
        List<List<Integer>> res;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            res = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates,target,new ArrayList<>(),0);
            return res;
        }

        public void backtrack(int[] candidates,int remains,List<Integer> path,int start) {
            if (remains == 0) {
                res.add(new ArrayList<>(path));
            }

            for (int i = start;i < candidates.length;i++) {
                if (candidates[i] > remains)  return;
                path.add(candidates[i]);
                backtrack(candidates,remains - candidates[i],path,i);
                path.remove(path.size() - 1);
            }

        }
    }
}
