package leetcode.algorithm.section6;

import org.junit.Test;

/**
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则保证它是 唯一 的。
 *
 * 提示:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 100000
 * 0 <= gas[i], cost[i] <= 10000
 *
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) return gas[0] > cost[0] ? 0 : -1;
        int end = 0,start = gas.length - 1,sum = 0;
        while (end <= start){
            if(sum + gas[end] - cost[end] >= 0){
                sum += gas[end] - cost[end];
                end++;
            }else {
                sum += gas[start] - cost[start];
                start--;
            }
        }
        return sum >= 0 ? (start + 1 >= gas.length ? 0 : start + 1) : -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < min){
                min = sum;
                index = i + 1;
            }
        }
        return sum < 0 ? - 1 : index;
    }

    @Test
    public void test(){
        int[] a ={1,2,3,4,5,1,12};
        int[] b ={10,10,1,1,1,1,1};
        System.out.println(canCompleteCircuit2(a, b));
    }
}
