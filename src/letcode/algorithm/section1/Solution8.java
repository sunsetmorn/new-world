package letcode.algorithm.section1;
/**
 * 取字符中前部分的整数
 * 类似与c和c++中的Atoi这个函数
 */
public class Solution8 {
        public static int myAtoi(String s) {
            s = s.trim();
            if(s.isEmpty())return 0;
            int l =1;
            int tmp =0;
            if(s.charAt(0) =='+') l = 1;
            else if(s.charAt(0) =='-') l = -1;
            else if(s.charAt(0) >='0' && s.charAt(0) <='9'){
                tmp = s.charAt(0) -'0';
            }else{
                return 0;
            }
            for(int i=1;i<s.length();i++){
                //先判断异常情况，会节省很多空间
                if(s.charAt(i) <'0' || s.charAt(i) >'9'){
                    break;
                }else {
                    int tmp2 = tmp*10 +(s.charAt(i)-'0');
                    if(tmp2/10 !=tmp){
                        tmp = l > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        return tmp;
                    }
                    tmp = tmp*10 + (s.charAt(i)-'0');
                }
            }
            return l*tmp;
        }

        /*时间最短算法*/
    public int myAtoi1(String s) {
        //整体思路：先根据前序条件转换字符串，再判断该数是否在取值范围内

        //0.读入前导空格，并忽略掉。即从第一个非空格的字符开始读取：

        int len = s.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = s.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String a ="42";
        System.out.println(a.charAt(0));
        int b =myAtoi(a);
        System.out.println(b);
    }
}
