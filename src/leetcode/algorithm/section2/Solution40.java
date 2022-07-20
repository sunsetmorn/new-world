package leetcode.algorithm.section2;

import java.util.*;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 *
 * 提示：
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Solution40 {
    static List<List<Integer>> retList;
    static Map<Integer,Integer> mm;
    static List<Integer> nums;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length ==0) return null;
        Arrays.sort(candidates);
        if(candidates[0] <= 0) return null;
        retList = new ArrayList<>();
        nums = new ArrayList<>();
        mm = new HashMap<>();
        List<Integer> start = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++){
            if(nums.size()>0 && nums.contains(candidates[i])){
                mm.put(candidates[i],mm.get(candidates[i])+1);
            }else{
                nums.add(candidates[i]);
                mm.put(candidates[i],1);
            }
        }
        add(0,start,target);
        return retList;
    }

    public static void add(Integer key,List<Integer> path,Integer remain){
       for(int i = 0 ; i <= mm.get(nums.get(key)) ;i++){
           for(int j = 0; j < i ; j++){
               path.add(nums.get(key));
           }
           if(remain == nums.get(key)*i){
               retList.add(new ArrayList<>(path));
               for(int j = 0; j < i ; j++){
                   path.remove(path.size()-1);
               }
               return;
           }
           if(remain > nums.get(key)*i && key < nums.size()-1){
               add(key+1,path,remain-nums.get(key)*i);
           }
           for(int j = 0; j < i ; j++){
               path.remove(path.size()-1);
           }
       }
    }

    public static void main(String[] args) {
        int[] i = {10,1,2,7,6,1,5,1,2,4};
        int t = 10;
        List<List<Integer>> lists = combinationSum3(i, t);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> combination = new ArrayList<>();
        if(len == 0) {
            return combination;
        }
        Arrays.sort(candidates);
        Deque<Integer> queue = new LinkedList<>();
        dfs(candidates, 0, len, target, queue, combination);
        return combination;
    }

    public static void dfs(int[] candidates, int start, int len, int target,  Deque<Integer> queue, List<List<Integer>> combination) {
        if(target == 0) {
            combination.add(new ArrayList<Integer>(queue));
            return;
        }
        for(int i = start; i < len; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            if(i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            queue.addLast(candidates[i]);
            dfs(candidates, i+1, len, target - candidates[i], queue, combination);
            queue.removeLast();
        }
    }


}
