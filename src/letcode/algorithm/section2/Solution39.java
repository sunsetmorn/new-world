package letcode.algorithm.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص���������candidates ��һ��Ŀ������target���ҳ�candidates�п���ʹ���ֺ�ΪĿ����target�����в�ͬ��ϣ�
 * �����б���ʽ���ء�����԰�����˳�򷵻���Щ��ϡ�
 * candidates�е�ͬһ�����ֿ����������ظ���ѡȡ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 * ���ڸ��������룬��֤��Ϊtarget�Ĳ�ͬ��������� 150 ����
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
