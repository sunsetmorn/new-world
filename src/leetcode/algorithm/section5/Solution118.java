package leetcode.algorithm.section5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution118
 * @description:
 * @date 2023年10月17日
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 提示:
 * 1 <= numRows <= 30
 */

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        int[][] array = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            array[i][0] = array[i][i] = 1;
        }
        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        ret.add(tmp1);
        if(numRows == 1){
            return ret;
        }
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                tmp.add(array[i][j]);
            }
            tmp.add(1);
            ret.add(tmp);
        }
        return ret;
    }
}
