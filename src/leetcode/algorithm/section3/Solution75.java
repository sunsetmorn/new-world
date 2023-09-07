package leetcode.algorithm.section3;

/**
 *  给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class Solution75 {
    public static void sortColors(int[] nums) {
        int a = 0,b = 0;
        for (int num : nums) {
            if(0 == num){
                a++;
            }else if(1 == num){
                b++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < a){
                nums[i] = 0;
            }else if(i <= a + b - 1){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,2,2,2};
        sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
