package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 *
 * ��ʾ��
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        int max = -10000; //ȡ��Χ����С����
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if(tmp > max){
                max = tmp;
            }
            if(tmp < 0){
                tmp = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-1,9,-1,0,3,-4};
        System.out.println(maxSubArray(a));
    }
}
