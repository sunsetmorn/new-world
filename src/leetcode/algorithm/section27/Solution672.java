package leetcode.algorithm.section27;

/**
 * 灯泡开关 Ⅱ
 * 房间中有 n?只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 * 这 4 个开关各自都具有不同的功能，其中：
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 *
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 */
public class Solution672 {
    /**
     * n:
     * 开关		    1		2		3		4       如：n=4
     * 基数非1+3k	变		不变	变		不变	 1 (3)
     * 偶数非1+3k	变		变		不变	不变	 1 (2)
     * 基数是1+3k	变		不变	变		变		 1 (1)
     * 偶数是1+3k	变		变		不变	变		 1 (4)
     *
     * presses:
     * 开关		    1		2		 3	     4
     *按压次数       t       t        t       t
     *有效按压次数   t%2     t%2      t%2     t%2
     *
     * 结果场景    1+1  1    2    3    4   1+4  2+4  3+4
     * 基数非1+3k  开   关   开   关   开   关   开   关
     * 偶数非1+3k  开   关   关   开   开   关   关   开
     * 基数是1+3k  开   关   开   关   关   开   关   开
     * 偶数是1+3k  开   关   关   开   关   开   开   关
     *
     * @param n
     * @param presses
     * @return
     */

    public int flipLights(int n, int presses) {
        if(n >= 3 && presses >= 3)   return 8;
        if(presses == 1) {
            if(n >= 3)  return 4;
            else   return n + 1;
        }
        if(presses >= 2) {
            if(n == 1)  return 2;
            else if(n == 2) return 4;
            else return 7;
        }
        if(presses == 0)
            return 1;
        return 0;
    }
}
