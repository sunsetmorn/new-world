package leetcode.algorithm.section2;

/**
 * 给定一个长度为n的0索引整数数组nums。初始位置为nums[0]。
 * 每个元素nums[i]表示从索引i向前跳转的最大长度。换句话说，如果你在nums[i]处，你可以跳转到任意nums[i + j]处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达nums[n - 1]的最小跳跃次数。生成的测试用例可以到达nums[n - 1]
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 *
 * 关键：每一步走的下一步能到的最远的位置（max(i+nums[i])）的那个就是最好的。
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
     * 最短时间算法
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
         * 从第一位开始，向前找第一步中能走的最远的路程。
         * 循环向前找
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
