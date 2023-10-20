package leetcode.algorithm.section5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution119
 * @description:
 * @date 2023年10月18日
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *提示:
 * 0 <= rowIndex <= 33
 */

public class Solution119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex == 0) {
            ret.add(1);
        } else {
            int[] a = new int[rowIndex + 1];
            a[0] = 1;
            int[] b = new int[rowIndex + 1];
            for (int i = 0; i < rowIndex + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if(j == 0) {
                        b[j] = 1;
                    }else {
                        b[j] = a[j] + a[j - 1];
                    }
                    if(j == i){
                        a = b.clone();
                    }
                }
            }
            for (int value : a) {
                ret.add(value);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int a = 2;
        getRow(a);
    }
}
