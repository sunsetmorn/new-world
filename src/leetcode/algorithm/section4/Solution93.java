package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution93
 * @description:
 * @date 2023年09月21日
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 提示：
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */

public class Solution93 {
    static List<String> ret = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return ret;
        get(s,3,new StringBuffer());
        return ret;
    }

    private static void get(String s,int times,StringBuffer st){
        if(times <= 0) {
            if(s.length() < 1 || '0' == s.charAt(0) && s.length() > 1) return;
            if(Integer.parseInt(s) > 255) return;
            ret.add(st.append(s).toString());
            return;
        }
        if(s.length() < 1) return;
        if(s.charAt(0) == '0'){
            st.append('0').append(".");
            get(s.substring(1),times - 1,st);
        }else {
            for (int i = 1; i <= 3; i++) {
                if(s.length() < i) return;
                if(Integer.parseInt(s.substring(0,i)) <= 255){
                    String s1 = st.toString();
                    st.append(s, 0, i).append(".");
                    get(s.substring(i),times - 1,st);
                    st = new StringBuffer(s1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String a = "0";
        for (String restoreIpAddress : restoreIpAddresses(a)) {
            System.out.println(restoreIpAddress);
        }
    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses2(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
