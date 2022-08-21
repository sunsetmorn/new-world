package leetcode.algorithm.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص���������candidates��һ��Ŀ������target���ҳ�candidates�п���ʹ���ֺ�ΪĿ����target�����в�ͬ��ϣ�
 * �����б���ʽ���ء�����԰�����˳�򷵻���Щ��ϡ�
 * candidates�е�ͬһ�����ֿ����������ظ���ѡȡ���������һ�����ֱ���ѡ������ͬ������������ǲ�ͬ�ġ�
 * ���ڸ��������룬��֤��Ϊtarget�Ĳ�ͬ���������150����
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
     * leetcode��췽��
     * �����淽���Ż���
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
