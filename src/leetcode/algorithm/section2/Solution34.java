package leetcode.algorithm.section2;

/**
 *  ����һ�������������е���������nums����һ��Ŀ��ֵtarget���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * ��������в�����Ŀ��ֵtarget������?[-1, -1]��
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0 || target > nums[nums.length-1] || target < nums[0]){
            return new int[]{-1, -1};
        }
        int start = -1;
        int end = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(target < nums[i]){
                break;
            }else if(target == nums[i]){
                end = i;
                if(start == -1){
                    start = i;
                }
            }
        }
        return new int[]{start, end};
    }
}
