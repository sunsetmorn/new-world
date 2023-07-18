package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组intervals表示若干个区间的集合，其中单个区间为intervals[i]=[starti, endi]。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 1 <= intervals.length <= 10000
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10000
 */
public class Solution56 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length ; i++){
            list.add(intervals[i]);
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] <= list.get(i-1)[1]){
                list.get(i-1)[1] = list.get(i-1)[1] > list.get(i)[1] ? list.get(i-1)[1]: list.get(i)[1];
                list.remove(i);
                i--;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> result = new ArrayList<int[]>();
        int i=0;
        int a = start[0];
        while(i<intervals.length){
            if(i==intervals.length -1){
                result.add(new int[]{a,end[i]});
            } else if(end[i]<start[i+1]){
                result.add(new int[]{a,end[i]});
                a = start[i+1];
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge3(int[][] intervals) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int[] i : intervals){
            max = Math.max(max, i[1]);
            min = Math.min(min, i[0]);
        }
        int len = max - min + 1;
        int[] pos = new int[len];
        for (int[] tuple : intervals) {
            int index = tuple[0] - min;
            if (pos[index] > 0) {
                if(pos[index] < tuple[1] - min)
                    pos[index] = tuple[1] - min;
            } else {
                pos[index] = tuple[1]-min;
            }
        }
        int start = 0;
        int end = pos[0];
        ArrayList<int[]> result = new ArrayList<>(intervals.length >> 1);
        for (int i = 1; i < len; i++) {
            if (pos[i] != 0) {
                if (i <= end) {
                    end = Math.max(end,pos[i]);
                } else {
                    result.add(new int[]{start+min,end+min});
                    start = i;
                    end = pos[i];
                }
            }
        }
        result.add(new int[]{start+min,end+min});
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3},{6,7}};
        int[][] merge = merge3(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0]+","+ints[1]);
        }
    }
}
