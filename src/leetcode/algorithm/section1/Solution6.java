package leetcode.algorithm.section1;
/**
 * Z字转换
 *
 *
 *
 */
public class Solution6 {
    //原创解 ，暂未优化
    public static String convert(String s, int numRows) {
        if(numRows <= 1 || s.isEmpty() || numRows >= s.length() ) return s;
        int n = numRows;
        char chars[] = s.toCharArray();
        int len = chars.length - 1;
        char newChars[] = new char[chars.length];
        int k = 2*n-2; //除数
        int d = len/k; //商
        int r = len%k; //余数
        int[] rowNum = new int[n]; //每行字符数
        rowNum[0] = d;
        rowNum[n-1] = d;
        if(r>=n-1) rowNum[n-1] = d+1;
        for(int i = 1; i < n-1 ; i++){
            rowNum[i] =2*d;
            if(r >= i) rowNum[i] = 2*d +1;
            if(r >= k-i) rowNum[i] = 2*d +2;
        }

        for (int j=0; j < chars.length; j++){
            int line; //第j字符所在行数,行数以0为起点，对应上面计算的每行个数
            int d1 = j/k;
            int r1 = j%k;
            if(r1 < n){
                line = r1;
            }else{
                line = k - r1;
            }

            int l; //第j字符所在行的位数
            if(r1 ==0) {
                l = d1;  //第一行的位数从0开始计数
            } else if(r1 ==n-1){
                l = d1;
                if(r1 >= n-1) l = d1 +1;
            }else{
                l = 2*d1;
                if(r1 >= line) l = 2*d1 +1;
                if(r1 >= k-line) l = 2*d1 +2;
            }

            int finalNum =l;
            for(int i = 0; i < n ; i++){
                if(line > i){
                    finalNum += rowNum[i];
                }
            }
            newChars[finalNum] = chars[j];
        }
        return String.valueOf(newChars);
    }

    //leetcode 最短时间解题方法
    public String convert2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int n = 2 * numRows - 2;        //每组有2n-2个元素
        int minCol = s.length() / n;   //共有多少完整组
        int index,ci = 0;
        for (int i = 0; i < numRows; i++) { //按行循环
            for (int j = 0; j < minCol + 1; j++) { //按每个V进行循环（V的结尾点算下一个循环）
                index = j * n + i;
                if (index < s.length()) {
                    chars[ci++] = s.charAt(index);  //先取V第一划与改行交集的数
                }
                //不是第一行和最后一行
                if (i != 0 && i != numRows - 1) { //首行和末尾行不存在第二个交点
                    index = j * n + i + 2 * (numRows - i - 1);//再取V第二划与改行交集的数
                    if (index < s.length())
                        chars[ci++] = s.charAt(index);
                }
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String a = "123456789";
        int b =3;
        String c =convert(a,b);
        System.out.println(c);
    }
}
