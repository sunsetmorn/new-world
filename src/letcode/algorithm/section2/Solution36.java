package letcode.algorithm.section2;


/**
 * �����ж�һ��9 x 9�������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ�����ο�ʾ��ͼ��
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {

        if(board[0].length != 9 || board.length != 9){
            return false;
        }

        byte[][] flags2 = new byte[9][9];
        byte[][][] flags3 = new byte[3][3][9];
        for(int i=0; i<9; i++){
            byte[] flags1 = new byte[9];
            for(int j=0;j<9;j++){
                if(board[i][j] > 48 && board[i][j] <= 57){
                    if(flags1[board[i][j]-49] ==1){
                        return false;
                    }else{
                        flags1[board[i][j]-49] =1;
                    }
                    if(flags2[j][board[i][j]-49] ==1){
                        return false;
                    }else{
                        flags2[j][board[i][j]-49] =1;
                    }
                    if(flags3[i/3][j/3][board[i][j]-49] ==1){
                        return false;
                    }else{
                        flags3[i/3][j/3][board[i][j]-49] =1;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int[] row = new int[9], col = new int[9];   //ʹ�ö����ƴ�������byte[]��Ϊ�жϱ�־λ��
        int[] v = new int[9];// java�����ʼ��Ĭ��Ϊ0
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = 1 << (board[i][j] - '0'); //��λ����ǰ���ִ洢λ
                int b = (i / 3 )* 3 + j / 3;        //��9*9�ĸ�����Ϊ�Ÿ�������3*3�ĸ��ӣ������Ϊ1~9��ʹ�������������ǰ����������ͬ�����ơ�
                if ((row[i] & num) != 0 || (col[j] & num) != 0 || (v[b] & num) != 0) return false;
                row[i] |= num;
                col[j] |= num;
                v[b] |= num;
            }
        }
        return true;
    }
}
