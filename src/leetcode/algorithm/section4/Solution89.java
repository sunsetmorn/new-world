package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution89
 * @description:
 * @date 2023年09月18日
 */

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
 * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * 提示：
 * 1 <= n <= 16
 *
 */
public class Solution89 {

    /**
     * n-1位的格雷码序列进行列表翻转后，所有数字的第n位数字从0变成1，此时队列是连续的，
     * 且表示2^n-1到2^n的所有数，此时将转换后的队列拼接到n-1格雷队列上则组成的就是n位格雷队列。
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }

}
