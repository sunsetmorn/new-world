package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个无重叠的，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 提示：
 * 0 <= intervals.length <= 10000
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 100000
 * intervals 根据 intervals[i][0] 按升序排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 100000
 */
public class Solution57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean flag = true;
        for (int i = 0; i < intervals.length; i++) {
            if (start > intervals[i][1]) {
                tmp.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            if (end < intervals[i][0]) {
                if(flag){
                    tmp.add(new int[]{start, end});
                    flag = false;
                }
                tmp.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            if (start > intervals[i][0]) {
                start = intervals[i][0];
            }
            if (end < intervals[i][1]){
                end = intervals[i][1];
                if(flag){
                    tmp.add(new int[]{start, end});
                    flag = false;
                }
            }
        }
        if(flag){
            tmp.add(new int[]{start, end});
        }
        return tmp.toArray(new int[tmp.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {};
        int[] b = {5,7};
        int[][] insert = insert(a, b);
        System.out.println(insert);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n <= 0){
            int[][] r = new int[1][];
            r[0] = newInterval;
            return r;
        }
        int[][] r = new int[n+1][];
        int i = 0;
        while(i < n){
            if(intervals[i][0] < newInterval[0]){
                i++;
            }else {
                break;
            }
        }
        int j = 0;
        while(j < i-1){
            r[j] = intervals[j];
            j++;
        }
        int k = i;
        int left = newInterval[0],right = newInterval[1];
        if(i > 0 && intervals[i-1][1] >= left){
            left = intervals[i-1][0];
            right = Math.max(intervals[i-1][1],right);
        }else {
            if(i > 0) r[j++] = intervals[i-1];
        }
        while(k < n && intervals[k][0] <= right){
            right = Math.max(intervals[k][1],right);
            k++;
        }
        r[j++] = new int[]{left,right};
        while(k < n){
            r[j++] = intervals[k++];
        }
        int[][] rt = new int[j][];
        i = 0;
        for(i = 0;i < j;i++){
            rt[i] = r[i];
        }
        return rt;
    }
}
