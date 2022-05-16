package leetcode.algorithm.section2;

/**
 * ����һ�������� n �����������еĵ� n �
 *��������С���һ���������У������� 1 ��ʼ�������е�ÿһ��Ƕ�ǰһ���������
 *
 * ǰ�������£�
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * ��һ�������� 1
 * ����ǰһ�������� 1 �� �� һ �� 1 �������� "11"
 * ����ǰһ�������� 11 �� �� �� �� 1 �� ������ "21"
 * ����ǰһ�������� 21 �� �� һ �� 2 + һ �� 1 �� ������ "1211"
 * ����ǰһ�������� 1211 �� �� һ �� 1 + һ �� 2 + �� �� 1 �� ������ "111221"
 */
public class Solution38 {
    public static String countAndSay(int n) {
        if(n<=0) return null ;
        String start ="1";
        if(n==1) return start;
        for(int i=1;i<n;i++){
            start =getNextOne(start);
        }
        return start;
    }

    public static String getNextOne(String str){
        StringBuilder stb = new StringBuilder();
        for(int i=0;i < str.length();i++){
            if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                if(i+2<str.length() && str.charAt(i)==str.charAt(i+2)){
                    stb.append("3").append(str.charAt(i));
                    i+=2;
                }else{
                    stb.append("2").append(str.charAt(i));
                    i++;
                }
            }else{
                stb.append("1").append(str.charAt(i));
            }
        }

        return stb.toString();
    }

    public static void main(String[] args) {
        String s = countAndSay(6);
        System.out.println(s);
    }
}
