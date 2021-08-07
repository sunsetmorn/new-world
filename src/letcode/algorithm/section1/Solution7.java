package letcode.algorithm.section1;
/**
 * 整数反转
 *
 */
public class Solution7 {
    /*原创解，未优化*/
    public static int reverse(int x) {
        //2^31 =2147483648
        long ret0 = 0;
        int ret1 = 0;
        int tmp = x;
        for(int i=0; i<10;i++){
            ret0 =ret1;
            if(10*ret0 + tmp%10 > Math.pow(2,31) - 1 || -Math.pow(2,31) > 10*ret0 + tmp%10) return 0;
            ret1 = 10*ret1 + tmp%10;

            if(tmp/10 >= 1 || tmp/10 <= -1){
                tmp = tmp/10;
            }else{
                break;
            }
        }
        if(-Math.pow(2,31) > ret1 ||  ret1 > Math.pow(2,31) - 1 ) return 0;
        return ret1;
    }

    /*最短时间解范例*/
    public int reverse1(int x) {
        if(x>Integer.MAX_VALUE){
            return 0;
        }
        int reg = x>0?1:-1;
        x = x*reg;
        int ret =0;
        while(x>0){
            int n = ret * 10;
            n = n + x%10;
            x= x/10;

            if(n/10!=ret){
                return 0;
            }
            ret =n;
        }
        return ret * reg;
    }


    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(reverse(a));
    }
}
