package letcode.algorithm.section2;


/**
 * 请你判断一个9 x 9的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字?1-9?在每一行只能出现一次。
 * 数字?1-9?在每一列只能出现一次。
 * 数字?1-9?在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
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
        int[] row = new int[9], col = new int[9];   //使用二进制代替数组byte[]作为判断标志位。
        int[] v = new int[9];// java数组初始化默认为0
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = 1 << (board[i][j] - '0'); //移位到当前数字存储位
                int b = (i / 3 )* 3 + j / 3;        //将9*9的格子视为九个单独的3*3的格子，并编号为1~9，使第三个条件变成前两个条件的同类限制。
                if ((row[i] & num) != 0 || (col[j] & num) != 0 || (v[b] & num) != 0) return false;
                row[i] |= num;
                col[j] |= num;
                v[b] |= num;
            }
        }
        return true;
    }
}
