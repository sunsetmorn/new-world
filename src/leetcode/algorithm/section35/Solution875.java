package leetcode.algorithm.section35;

/**
 * ����ϲ�����㽶�������� n ���㽶���� i ������piles[i]���㽶�������Ѿ��뿪�ˣ����� h Сʱ�������
 * ������Ծ��������㽶���ٶ� k ����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ���㽶�����гԵ� k �����������㽶���� k ���������Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��??
 * ����ϲ�������ԣ�����Ȼ���ھ�������ǰ�Ե����е��㽶��
 * ������������ h Сʱ�ڳԵ������㽶����С�ٶ� k��k Ϊ��������
 */
public class Solution875 {
    public static int minEatingSpeed(int[] piles, int h) {

        int max=0;
        for (int i:piles) {
            if(max<i) max=i;
        }

        int start =1;
        int end = max;
        while(start < end){
            int speed = (start+end)/2;
            int s = get(speed, piles);
            if(s<=h){
                end = speed;
            }else{
                start = speed+1;
            }
        }

        return start;
    }

    public static int get(int speed ,int[] piles){
        int sum=0;
        for(int pile:piles){
            sum += (pile-1+speed)/speed;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        int i = minEatingSpeed(piles, h);
        System.out.println(i);
    }
}
