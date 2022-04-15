package letcode.algorithm.section2;

/**
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
 */
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0 ){
            return 0;
        }
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length-1]< target){
            return nums.length;
        }

        return dichotomy(nums,0,nums.length-1,target);
    }

    public static int dichotomy(int[] nums,int start,int end,int target){
        if(start >= end){
            if(nums[start] >= target){
                return start;
            }else {
                return start+1;
            }
        }
        int med = (start+end)/2;
        if(nums[med]== target){
            return med;
        }else if(nums[med] > target){
            return dichotomy(nums,start,med-1,target);
        }else{
            return dichotomy(nums,med+1,end,target);
        }
    }

    public static void main(String[] args) {
        int[] a = {3,5,7,9,10};
        int b =8;
        System.out.println(searchInsert(a, b));
    }
}
