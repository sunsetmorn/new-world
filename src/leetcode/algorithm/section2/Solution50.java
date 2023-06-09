package leetcode.algorithm.section2;

/**
 * ʵ�� pow(x,n) ��������x������n���ݺ���������x^n��
 *
 * ��ʾ:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n��һ������
 * Ҫôx��Ϊ�㣬Ҫô n > 0 ��
 * -10^4 <= x^n <= 10^4
 *
 */
public class Solution50 {
    /**
     *  ��ָ���ķ�Χ������������������ڴ�Ŵ󣬱���߽�����쳣��
     *  ָ��Ϊ��ֱ��ȡ�����������ָ��Ϊ��ȡ������
     *  ָ�����վ���ֵ�����������
     *  ָ����2ȡ�࣬
     *      ����Ϊ0�����԰ѵ�����Ϊƽ����ָ������
     *      ������Ϊ0�������������ó����ͣ��˵������
     */
    public static double myPow(double x, int n) {
        double ans = 1;
        long N = Math.abs((long)n);
        while (N > 0)
        {
            if (N % 2 != 0){
                ans *= x;
            }
            N /= 2;
            x *= x;
        }
        return n > 0? ans : 1.0 / ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,100));
    }
}
