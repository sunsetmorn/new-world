package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution88
 * @description:
 * @date 2023年09月18日
 */

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -1000000000 <= nums1[i], nums2[j] <= 1000000000
 *
 *
 */
public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m - 1,j = n - 1,tmp = m + n -1; j >= 0;){
            if(i < 0 || nums1[i] <= nums2[j]){
                nums1[tmp] = nums2[j];
                j--;
            }else{
                nums1[tmp] = nums1[i];
                i--;
            }
            tmp--;
        }
    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {1};
        merge(a,0,b,1);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
