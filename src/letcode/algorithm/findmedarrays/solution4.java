package letcode.algorithm.findmedarrays;
/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class solution4 {
    /**
     * 3 ms
     * 39.6 MB
     **/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count1 =0,count2=0;
        if((nums1.length + nums2.length)%2 == 0){
            count1 = (nums1.length + nums2.length)/2;
            count2 = count1 -1;
        }else{
            count1 = (nums1.length + nums2.length)/2;
            count2 =count1;
        }
        int i=0,j=0,num=0;
        int a[] = new int[count1 +1];
        double ret = 0.0;
        while(i <= nums1.length && j <= nums2.length){
            if(i >=nums1.length){
                a[i+j] = nums2[j++];
            }else if(j >= nums2.length){
                a[i+j] = nums1[i++];
            }else {
                a[i+j] = nums1[i] < nums2[j]?nums1[i++]:nums2[j++];
            }
            if(i + j > count1){
                ret = ((double)a[count1] + (double)a[count2])/2;
                break;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int a[] = {1,2};
        int b[] = {3,4};
        double c = findMedianSortedArrays(a,b);
        System.out.println(c);
    }
}
