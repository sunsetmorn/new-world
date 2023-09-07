package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 提示:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 */
public class Solution68 {

    /**
     * 注意一行只有一个单词时，补充空格到结尾
     * 一行多个单词时，空格是均匀从左到右分布在单词之间
     * 最后一行单词之间只有一个空格，剩余空格都在结尾。
     * @param words
     * @param maxWidth
     * @return
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        int tmp = 0;
        int tmp2 = 0;
        for (int i = 0; i < words.length; i++) {
            int total = 0;
            if(tmp == 0){
                total = tmp + words[i].length();
            }else {
                total = tmp + words[i].length() + 1;
            }
            if(total > maxWidth){
                nums.add(tmp2);
                nums2.add(tmp);
                tmp2 = 1;
                tmp = words[i].length();
            }else if(total == maxWidth){
                nums.add(tmp2 + 1);
                nums2.add(total);
                tmp2 = 0;
                tmp = 0;
            }else {
                tmp = total;
                tmp2++;
            }
        }
        List<String> ret = new ArrayList<>();
        if(tmp2 > 0) {
            nums.add(tmp2);
            nums2.add(tmp);
        }
        int flag = 0;
        for (int i = 0; i < nums.size(); i++) {
            int t = maxWidth - nums2.get(i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(words[flag++]);
            String blank = "";
            int gap = nums.get(i) == 1 ? 1 : nums.get(i) - 1;
            for (int i1 = 0; i1 < t / gap; i1++) {
                blank += " ";
            }
            if(i == nums.size() - 1){
                for (int j = 1; j < nums.get(i); j++) {
                    stringBuffer.append(" ").append(words[flag++]);
                }
                for(int j = 0;j < t;j++){
                    stringBuffer.append(" ");
                }
            }else if(nums.get(i) == 1) {
                stringBuffer.append(blank);
            }else if(t % gap == 0){
                for (int j = t % gap + 1; j < nums.get(i); j++) {
                    stringBuffer.append(blank).append(" ").append(words[flag++]);
                }
            }else {
                for (int i1 = 0; i1 < t % gap; i1++) {
                    stringBuffer.append(blank).append("  ").append(words[flag++]);
                }
                for (int j = t % gap + 1; j < nums.get(i); j++) {
                    stringBuffer.append(blank).append(" ").append(words[flag++]);
                }
            }
            ret.add(stringBuffer.toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
        List<String> strings = fullJustify(words, 20);
        strings.forEach(System.out::println);
    }
}
