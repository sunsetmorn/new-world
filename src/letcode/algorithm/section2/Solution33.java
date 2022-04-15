package letcode.algorithm.section2;

/**
 * ��������nums���������У������е�ֵ������ͬ ��
 * �ڴ��ݸ�����֮ǰ��nums��Ԥ��δ֪��ĳ���±�k��0<=k<nums.length���Ͻ�������ת��
 * ʹ�����Ϊ[nums[k],nums[k+1],...,nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ ��������
 * ���磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ?[4,5,6,7,0,1,2] ��
 * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻�?-1?
 */
public class Solution33 {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(target < nums[0]){
            for(int i=nums.length-1;i>=0;i--){
                if(target > nums[i]){
                    break;
                }else if(target == nums[i]){
                    return i;
                }
            }
        }else{
            for(int i=0;i< nums.length;i++){
                if(target < nums[i]){
                    break;
                }else if(target == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a= new int[]{4,5,6,7,0,1,2};
        int target =0;
        int t = search(a,target);
        System.out.println(t);
    }
}
