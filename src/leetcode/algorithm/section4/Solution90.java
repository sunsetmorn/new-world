package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution90
 * @description:
 * @date 2023年09月20日
 */


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            tmp.clear();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                //按照i的二进制值决定是否取值
                if ((i & (1 << j)) != 0) {
                    /**
                     * 去重方法：
                     * 对数组进行排序，相同的值相邻排列。
                     * 同一个值不管取多少次，都优先取靠前位置的值。
                     * 如此做之后，有一个值没有取的时候后续所有相同数值都不再取，这样可以保证不会出现重复获取的情况。
                     *
                     * 此处做法：
                     * 如果前一个值和当前相同，且前一个值未取，则当前值不取。
                     */
                    if (j > 0 && (i >> (j - 1) & 1) == 0 && nums[j] == nums[j - 1]) {
                        flag = false;
                        break;
                    }
                    tmp.add(nums[j]);
                }
            }
            if(flag){
                ret.add(new ArrayList<>(tmp));
            }
        }
        return ret;
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        int n = nums.length;
        return new AbstractList<List<Integer>>() {
            private final List<List<Integer>> list = new ArrayList<>();
            private final List<Integer> comb = new ArrayList<>();

            @Override
            public List<Integer> get(int index) {
                init();
                return list.get(index);
            }

            @Override
            public int size() {
                init();
                return list.size();
            }

            void init() {
                if (list.isEmpty()) {
                    Arrays.sort(nums);
                    for (int k = 0; k <= n; k++) {
                        getComb(0, k);
                    }
                }
            }

            void getComb(int begin, int left) {
                if (left == 0) {
                    list.add(new ArrayList<>(comb));
                    return;
                }
                for (int i = begin; i < n - left + 1; i++) {
                    if (i > begin && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    comb.add(nums[i]);
                    getComb(i + 1, left - 1);
                    comb.remove(comb.size() - 1);
                }
            }
        };
    }
}
