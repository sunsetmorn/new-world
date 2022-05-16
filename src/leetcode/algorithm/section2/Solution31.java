package leetcode.algorithm.section2;

/**
 * ��һ������
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������У�������ϳ���һ���������������
 * �����������һ����������У��������������г���С�����У����������У���
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 */
public class Solution31 {
    /**
     * ˼·�������һλ���һλ��ʼѭ����ÿ���Һ���λ�õ������еıȸ��������С����û���������ǰ��
     * ���ҵ����򽻻�λ�ã���������������д�С�������򣬲�ֱ���˳���
     * ��Ϊ������ɣ���λ�ú������һ���ǵ������еģ��Ӵ�С���������ǰ����ѭ��������������С����ֻ��Ҫ�����һλ��ʼ
     * ���һֱû�ҵ�������е�����С��������
     */
    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length<1) return;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    changeNum(nums,i,j);
                    sortNum(nums,i+1);
                    return;
                }
            }
        }
        sortNum(nums,0);
    }

    public static void changeNum(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void sortNum(int[] nums,int a){
        for(int i=nums.length-1;i>a;i--){
            for (int j=a;j<i;j++){
                if(nums[j] > nums[i]){
                    changeNum(nums,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]= {1,2,1,0};
        nextPermutation(a);
        System.out.println("11111"+a);

    }
}
