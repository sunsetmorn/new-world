package leetcode.algorithm.section2;

/**
 * ����һ������Ϊn��0������������nums����ʼλ��Ϊnums[0]��
 * ÿ��Ԫ��nums[i]��ʾ������i��ǰ��ת����󳤶ȡ����仰˵���������nums[i]�����������ת������nums[i + j]��:
 * 0 <= j <= nums[i]
 * i + j < n
 * ���ص���nums[n - 1]����С��Ծ���������ɵĲ����������Ե���nums[n - 1]
 *
 * ��ʾ��
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * ��Ŀ��֤���Ե��� nums[n-1]
 *
 *
 * �ؼ���ÿһ���ߵ���һ���ܵ�����Զ��λ�ã�max(i+nums[i])�����Ǹ�������õġ�
 */
public class Solution45 {
    public static int jump(int[] nums) {
        int l = nums.length - 1;
        int[] lm = new int[nums.length];
        int times = 0;
        while(l > 0){
            for (int i = 0; i < l; i++) {
                if(l == nums.length - 1){
                    lm[i] = i + nums[i];
                }
                if(lm[i] >= l){
                    l = i;
                    times++;
                    break;
                }
            }
        }
        return times;
    }

    /**
     * ���ʱ���㷨
     */
        int count;
        public int jump2(int[] nums) {
            if(nums.length <= 1){
                return 0;
            }
            helper(nums, 0);
            return count;
        }

        /**
         * �ӵ�һλ��ʼ����ǰ�ҵ�һ�������ߵ���Զ��·�̡�
         * ѭ����ǰ��
         * @param nums
         * @param pos
         */
        private void helper(int[] nums, int pos){
            if(pos + nums[pos] >= nums.length - 1){
                count++;
                return;
            }
            int step = nums[pos];
            int offset = -1;
            int index = -1;
            for(int i = 1; i <= step; i++){
                if(i + nums[pos + i] > offset){
                    offset = i + nums[pos + i];
                    index = pos + i;
                }
            }
            if(index != -1){
                count++;
            }
            helper(nums, index);
        }


    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(jump(a));
    }
}
