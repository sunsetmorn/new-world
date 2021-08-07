package letcode.algorithm.section1;

public class Solution11 {
    public static int maxArea(int[] height) {
        int ret =0;
        if(height==null || height.length <=1) return ret;
        int k =0;
        for (int i:height) {
            k=k >i?k:i;
        }
        for(int i=0;i<height.length;i++){
            int a =1;
            if(height[i] ==0){
                continue;
            }
            if(k!=0 && ret/k > (height.length-i)){
                break;
            }
            if(ret !=0){
                a = ret/height[i];
            }
            for(int j=i+a; j<height.length; j++){
                int tmp = 1;
                if(height[i] < height[j]){
                    tmp = (j-i) * height[i];
                }else{
                    tmp = (j-i) * height[j];
                }
                if(ret < tmp){
                    ret = tmp;
                }
            }
        }
        return ret;
    }

    /**
     * leetcode最短用时解
     * 执行用时: 2 ms
     * 内存消耗: 52 MB
     */
    public int maxArea1(int[] height) {
        int l = 0, r= height.length-1;
        int maxN = 0;
        while(l < r){
            int h = Math.min(height[l],height[r]);
            int area = h * (r - l);
            maxN = Math.max(maxN,area);
            while(l < r && h >= height[l]){
                l++;
            }
            while(l < r && h >= height[r]){
                r--;
            }
        }
        return maxN;
    }


    /**
     * 最短用时解
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.93%的用户
     * 内存消耗：49.2 MB, 在所有 Java 提交中击败了98.07%的用户
     */
    public int maxArea2(int[] height) {
        int l = 0, r= height.length-1;
        int maxN = 0;
        int max =0;
        for (int i:height) {
            max=max >i?max:i;
        }
        while(l < r && max*(r-l) >maxN){
            int h = Math.min(height[l],height[r]);
            int area = h * (r - l);
            maxN = Math.max(maxN,area);
            while(l < r && h >= height[l]){
                l++;
            }
            while(l < r && h >= height[r]){
                r--;
            }
        }
        return maxN;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,12,14,12};
        System.out.println(maxArea(a));
    }
}
