package leetcode.algorithm.section3;

/**
 * ����һ���Ǹ���������nums�������λ������ĵ�һ���±ꡣ
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 *
 * 1 <= nums.length <= 3 * 10000
 * 0 <= nums[i] <= 100000
 */

public class Solution55 {
    public static boolean canJump(int[] nums) {
        int goal = nums.length -1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= goal) goal = i;
            if(goal == 0) return true;
        }
        return false;
    }
}
