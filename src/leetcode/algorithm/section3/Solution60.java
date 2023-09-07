package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 提示：
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class Solution60 {
    public static String getPermutation(int n, int k) {
        int[] max = new int[n];
        int[] ret = new int[n];
        List<Integer> tmpList = new ArrayList<>();
        int flag = 0;

        for(int i = 0; i < n; i++){
            if(i == 0){
                max[0] = 1;
            }else {
                max[i] = max[i - 1] * (i + 1);
            }
            tmpList.add(i + 1);
            if(max[i] >= k){
                flag = n - i - 1;
                int tmp = k;
                for(int j = i;j > 0; j--){
                    int t = tmp / max[j - 1];
                    tmp = tmp - t * max[j - 1];
                    if(tmp == 0){
                        ret[n - j - 1] = tmpList.get(t - 1);
                        tmpList.remove(t - 1);
                        tmp = max[j - 1];
                    }else {
                        ret[n - j - 1] = tmpList.get(t);
                        tmpList.remove(t);
                    }
                }
                if(tmpList.size() > 0) ret[n - 1] = tmpList.get(0);
                break;
            }
        }
        StringBuilder retS = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            if(ret[i] == 0){
                retS.append(i + 1);
            }else{
                retS.append(ret[i] + flag);
            }
        }
        return retS.toString();
    }

    public String getPermutation2(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(2, 2));
    }
}
