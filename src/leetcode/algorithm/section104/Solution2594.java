package leetcode.algorithm.section104;

import java.util.Map;

/**
 * @author zhaoxq
 * @ClassName Solution2594
 * @description:
 * @date 2023年09月07日
 *
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n * n 分钟内修好 n 辆车。
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * 请你返回修理所有汽车 最少 需要多少时间。
 * 注意：所有机械工可以同时修理汽车。
 *
 * 1 <= ranks.length <= 100000
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 1000000
 */

public class Solution2594 {

    /**
     * 二分查找法
     *
     *
     * @param ranks
     * @param cars
     * @return
     */
    public static long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) ranks[0] * cars * cars;
        while (l < r) {
            long m = l + r >> 1;
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean check(int[] ranks, int cars, long m) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(m / x);
        }
        return cnt >= cars;
    }

    public static long repairCars2(int[] ranks, int cars) {
        long[] l = new long[ranks.length];
        for (int i = 0; i < cars; i++) {
            long min = Long.MAX_VALUE;
            int f = -1;
            for (int j = 0; j < l.length; j++) {
                if(min > ranks[j] * (l[j] + 1) * (l[j] + 1)){
                    min = ranks[j] * (l[j] + 1) * (l[j] + 1);
                    f = j;
                }
            }
            l[f]++;
        }

        long ret = 0l;
        for (int i = 0; i < l.length; i++) {
            ret = Math.max(ret,ranks[i] * l[i] * l[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(repairCars(a, 736185));
    }
}
