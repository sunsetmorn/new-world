package leetcode.algorithm.section2;

import java.util.Arrays;

/**
 * ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
 * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
 *  1 <= nums.length <= 5 * 105
 *  -2^31 <= nums[i] <= 2^31 - 1
 */
public class Solution41 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ;  i++){
            if(nums[i] <= 1) continue;
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            if(i >= 1 && nums[i] != nums[i-1] + 1 ){
                return nums[i-1] + 1 > 0 ? nums[i-1] + 1 : 1;
            }
            if(i == 0 && nums[i] > 1){
                return 1;
            }
        }
        return  nums[nums.length-1] + 1 > 0 ? nums[nums.length-1] + 1 : 1;
    }


    /**
     * leetcode ���ʱ���㷨
     * ˵����
     *  �������[1,2,3,4,5,6...]��Ŀ������㡣���嵱ǰλ�ã������Чλ�ö�Ӧ���֡�
     *  ��λ���ж������Ƿ���ϣ�������ǰλ��+1��
     *  ������ʱ��С��Ҫ�����ֵ������������һλ����Ч���ֵ� �������һλ��Ч�������һλ��Чλ�ü���һ��
     *  �����м�ĳ��λ�ö�Ӧ������ֱ�ӻ�����λ�ã�����λ���Ѿ�����ʱ����ͬ��������ĩβ��
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int L = 0;
        int R = nums.length;
        while (L < R) {
            if (nums[L] == L + 1) {
                L++;
            } else if (nums[L] <= L || nums[L] > R || nums[nums[L] - 1] == nums[L]) {
                swap(nums, L, --R);
            } else {
                swap(nums, L, nums[L] - 1);
            }
        }
        return L + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
