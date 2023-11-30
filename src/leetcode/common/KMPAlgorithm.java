package leetcode.common;

/**
 * KMP算法
 */
public class KMPAlgorithm {


    /**
     * 获取next数组
     * 模式串 t 的每个元素 t[j]，都存在一个实数 k ，使得模式串 t 开头的 k 个字符（t[0] t [1]…t [k-1]）依次与 t [j]
     * 前面的 k（t [j-k] t [j-k+1]…t [j-1]，这里第一个字符 t [j-k] 最多从 t [1] 开始，所以 k < [j]）个字符相同。
     * 如果这样的 k 有多个，则取最大的一个
     */
    public static int[] getNext(String a) {
        int[] next = new int[a.length()];
        int m = 2, n = 1;
        next[0] = -1;
        next[1] = 0;
        while (m < a.length() - 1) {
            if (n != 0 && a.charAt(m) == a.charAt(next[n])) {
                next[m++] = next[n++];
            } else if (n == 0) {
                next[m++] = 0;
            } else {
                n = next[n];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String a = "anafbanhsbk";
        int[] b = getNext(a);
        System.out.println("61544");
    }
}
