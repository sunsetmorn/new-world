package leetcode.algorithm.section6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution131
 * @description:
 * @date 2023年10月27日
 * <p>
 * 131. 分割回文串
 * 给你一个字符串 s，请你将s分割成一些子串，使每个子串都是回文串 。返回 s 所有可能的分割方案。
 * 回文串是正着读和反着读都一样的字符串。
 * <p>
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<List<String>> tmp = new ArrayList<>();
        int[][] t = new int[s.length()][s.length()];
        List<String> list = new ArrayList<>();
        list.add(s.substring(0, 1));
        ret.add(list);
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            for (List<String> list1 : ret) {
                int size = list1.size();
                if (isPalindrome(list1.get(size - 1))) {
                    List<String> list2 = new ArrayList<>(list1);
                    list2.add(s1);
                    tmp.add(list2);
                }
                list1.set(size - 1, list1.get(size - 1) + s1);
                tmp.add(list1);
            }
            ret = new ArrayList<>(tmp);
            tmp = new ArrayList<>();
        }
        ret.removeIf(strings -> !isPalindrome(strings.get(strings.size() - 1)));
        return ret;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        backtrace(result, tempList, s, 0);
        return result;
    }

    private void backtrace(List<List<String>> result, List<String> tempList, String s, int start) {
        int length = s.length();
        if (start >= length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start + 1; i <= length; ++i) {
                String substring = s.substring(start, i);
                if (!isPalindrome(substring)) {
                    continue;
                }
                tempList.add(substring);
                backtrace(result, tempList, s, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    @Test
    public void test() {
        List<List<String>> aab = partition("aab");
        for (List<String> list : aab) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
