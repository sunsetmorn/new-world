package leetcode.algorithm.section6;

import org.junit.Test;

import java.util.*;

/**
 * @author zhaoxq
 * @ClassName Solution126
 * @description:
 * @date 2023年10月23日
 * <p>
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
 * 如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * 提示：
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 */

public class Solution126 {

    int[] times;
    String[] save;
    int[][] con;
    String begin;
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        begin = beginWord;
        ArrayList<String> strings = new ArrayList<>(wordList);
        if (!strings.contains(beginWord)) strings.add(beginWord);
        save = strings.toArray(new String[0]);
        times = new int[strings.size()];
        con = new int[strings.size()][strings.size()];
        if (!wordList.contains(endWord)) return ret;
        for (int i = 0; i < times.length; i++) {
            if (save[i].equals(beginWord)) times[i] = 1;
        }
        int flag = -1;
        for (int i = 0; i < save.length; i++) {
            if (save[i].equals(endWord)) flag = i;
        }
        int i = 1;
        while (true) {
            List<String> has = has(i);
            if (has.size() == 0) break;
            if (has.contains(endWord)) {
                ArrayList<String> s = new ArrayList<>();
                s.add(endWord);
                addNext(flag, s);
                break;
            }
            i++;
        }
        return ret;
    }

    private List<String> has(int time) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < save.length; i++) {
            if (times[i] == time) {
                for (int j = 0; j < save.length; j++) {
                    if (times[j] == 0 || times[j] == time + 1) {
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
            if (a.charAt(i) != b.charAt(i)) {
                t++;
            }
            if (t > 1) return false;
        }
        return t == 1;
    }

    private void addNext(int flag, List<String> tmp) {
        if (save[flag].equals(begin)) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < con.length; i++) {
            if (con[i][flag] == 1) {
                tmp.add(0, save[i]);
                addNext(i, tmp);
                tmp.remove(0);
            }
        }
    }

    int[][] contiguous;
    List<List<String>> ret2 = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)) return ret2;
        Arrays.fill(contiguous,beginWord.length());
        fillContiguous(wordList,beginWord.length());


        return ret2;
    }

    private void fillContiguous(List<String> wordList,int size){
        for (int i = 0; i < size; i++) {
            Map<Integer,List<Integer>> tmp = new HashMap<>();
            for (int j = 0; j < wordList.size(); j++) {
                int c = wordList.get(j).charAt(i);
                List<Integer> orDefault = tmp.getOrDefault(c, new ArrayList<>());
                for (int i1 = 0; i1 < orDefault.size(); i1++) {
                    contiguous[orDefault.get(i1)][j]--;
                    contiguous[j][orDefault.get(i1)]--;
                }
                orDefault.add(j);
                tmp.put(c,orDefault);
            }
        }
    }



    @Test
    public void test() {
        String begin1 = "a";
        String end1 = "c";
        String[] t = {"a", "b", "c"};
        List<String> strings = Arrays.asList(t);
        List<List<String>> ladders = findLadders(begin1, end1, strings);
        System.out.println("1111");
    }
}
