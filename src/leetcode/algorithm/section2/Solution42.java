package leetcode.algorithm.section2;

/**
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution42 {
    public static int trap(int[] height) {
        int length = height.length;
        if(length <=2) return 0;
        int[] plat = new int[length];
        plat[0] = height[0];

        for (int i = 1; i < length; i++) {
            int left = maxHeight(height,0, i);
            int right = maxHeight(height,i, length);
            int min = left < right ? left : right;
            plat[i] = height[i] < min ? min : height[i];
        }

        int sum = 0;
        for(int i = 0 ; i < length ; i++){
            sum+= (plat[i]-height[i]);
        }

        return sum;
    }

    public static int maxHeight(int[] height,int start,int end){
        int max =0;
        for(int i = start; i < end; i++){
            max = Math.max(height[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }


    /**
     * leetcode最短时间算法
     * 取最大值点，两边分别向逐个点计算积水量最后相加。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length <=1) {
            return 0;
        }
        int maxHeight =0;
        int maxHeightIndex = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        int area = 0;
        int tmp = height[0];
        for(int i = 0; i < maxHeightIndex; i++) {
            if(height[i] > tmp) {
                tmp = height[i];
            } else {
                area = area + (tmp - height[i]);
            }
        }
        int tmp1 = height[height.length-1];
        for(int j = height.length-1; j > maxHeightIndex; j--) {
            if(height[j] > tmp1) {
                tmp1 = height[j];
            } else{
                area = area + (tmp1 - height[j]);
            }
        }
        return area;
    }
}
