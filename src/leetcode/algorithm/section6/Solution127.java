package leetcode.algorithm.section6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhaoxq
 * @ClassName Solution127
 * @description:
 * @date 2023年10月23日
 * <p>
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * 提示：
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 */

public class Solution127 {

    int[] times;
    String[] save;
    int[][] con;
    String begin;
    List<List<String>> ret = new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        begin = beginWord;
        ArrayList<String> strings = new ArrayList<>(wordList);
        if (!strings.contains(beginWord)) strings.add(beginWord);
        save = strings.toArray(new String[0]);
        times = new int[strings.size()];
        con = new int[strings.size()][strings.size()];
        if (!wordList.contains(endWord)) return 0;
        for (int i = 0; i < times.length; i++) {
            if (save[i].equals(beginWord)) times[i] = 1;
        }
        int i = 1;
        while (true) {
            List<String> has = has(i++);
            if (has.size() == 0) break;
            if (has.contains(endWord)) {
                return i;
            }
        }
        return 0;
    }

    private List<String> has(int time) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < save.length; i++) {
            if (times[i] == time) {
                for (int j = 0; j < save.length; j++) {
                    if (times[j] == 0) {
                        if (isContiguous(save[i], save[j])) {
                            con[i][j] = 1;
                            times[j] = time + 1;
                            ret.add(save[j]);
                        }
                    }
                }
            }
        }
        return ret;
    }

    private boolean isContiguous(String a, String b) {
        int t = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) t++;
            if (t > 1) return false;
        }
        return t == 1;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!words.contains(endWord)) return 0;
        begin.add(beginWord);
        end.add(endWord);
        words.remove(beginWord);
        words.remove(endWord);
        int ans = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            ans++;
            if (begin.size() <= end.size()) {
                if (bfs(begin, end, words)) return ans;
            } else {
                if (bfs(end, begin, words)) return ans;
            }
        }
        return 0;
    }

    public boolean bfs(Set<String> from, Set<String> to, Set<String> words) {
        String[] s = from.toArray(new String[0]);
        for (String s1 : s) {
            char[] sc = s1.toCharArray();
            for (int i = 0; i < sc.length; i++) {
                for (char k = 'a'; k < 'z'; k++) {
                    char temp = sc[i];
                    sc[i] = k;
                    String scs = String.valueOf(sc);
                    if (to.contains(scs)) return true;
                    if (words.contains(scs)) {
                        from.add(scs);
                        words.remove(scs);
                    }
                    sc[i] = temp;
                }
            }
            from.remove(s1);
        }
        return false;
    }


}
