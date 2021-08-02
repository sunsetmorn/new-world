package letcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ����֮��
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��
 * ʹ��?a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 */
public class Solution15 {
    /**
     *
     * ִ����ʱ��17 ms, ������ Java �ύ�л�����99.88%���û�
     * �ڴ����ģ�42.6 MB, ������ Java �ύ�л�����29.55%���û�
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int len =nums.length;
        for(int i=0;i<len;i++){
            int tmp =nums[i];
            if(tmp > 0) return ret;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = len-1;
            while (l<r){
                if(tmp+nums[l]+nums[r] == 0){
                    List<Integer> tmps = new ArrayList<>();
                    tmps.add(tmp);
                    tmps.add(nums[l]);
                    tmps.add(nums[r]);
                    ret.add(tmps);
                    while (l<r && nums[l] ==nums[l+1]) l++;
                    while (l<r && nums[r] ==nums[r-1]) r--;
                    l++;
                    r--;
                }else if (tmp+nums[l]+nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> ret = threeSum(nums);
        for (List<Integer> i:ret) {
            System.out.print("[");
            for (Integer j:i) {
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println("]");
        }

    }
}
