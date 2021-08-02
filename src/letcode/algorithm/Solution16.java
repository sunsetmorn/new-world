package letcode.algorithm;

import java.util.Arrays;

/**
 * ��ӽ�������֮��
 */
public class Solution16 {
    /**
     * ִ����ʱ��6 ms, ������ Java �ύ�л�����72.44%���û�
     * �ڴ����ģ�7.7 MB, ������ Java �ύ�л�����96.63%���û�
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret =Integer.MAX_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int l = i+1, r =len -1;
            while(l<r){
                int tmp = nums[i] + nums[l] + nums[r];
                if(tmp > target){
                    if(Math.abs(tmp-target) < Math.abs(ret-target)){
                        ret =tmp;
                    }
                    r--;
                }else if (tmp == target){
                    return tmp;
                }else{
                    if(Math.abs(target-tmp) < Math.abs(ret-target)){
                        ret =tmp;
                    }
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,5,7};
        int b =13;
        System.out.println(threeSumClosest(a,b));
    }
}
