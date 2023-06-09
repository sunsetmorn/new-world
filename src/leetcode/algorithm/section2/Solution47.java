package leetcode.algorithm.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ɰ����ظ����ֵ�����nums��������˳�򷵻����в��ظ���ȫ���С�
 */
public class Solution47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        // �ӵ� 0 �㿪ʼ����
        dfs(0, nums, result);
        return result;
    }
    /** ������ level �� */
    private static void dfs(int level, int[] nums, List<List<Integer>> results) {
        if (level == nums.length) {
            // ��¼���
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(result);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            if (isRepeat(nums, level, i)) continue;
            // ���������Ԫ��
            swap(nums, level, i);
            // ��������
            dfs(level + 1, nums, results);
            // ��ԭ�ֳ�
            swap(nums, i, level);
        }
    }
    /** ���� i1 �� i2 λ�õ�Ԫ�� */
    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    /** ��� willSwap ���Ƿ����ظ���Ԫ�� */
    private static boolean isRepeat(int[] nums, int level, int willSwap) {
        for (int i = level; i < willSwap; i++) {
            if (nums[willSwap] == nums[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        permuteUnique(nums);
    }
}
