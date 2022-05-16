package letcode.algorithm.section2;


/**
 *  ��дһ������ͨ�����ո�������������⡣
 * �����Ľⷨ����ѭ���¹���
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ���
 * �������ֿո��������������֣��հ׸���'.'��ʾ��
 *
 * ��ʾ��
 * board.length == 9
 * board[i].length == 9
 * board[i][j] ��һλ���ֻ��� '.'
 * ��Ŀ���� ��֤ ������������һ����
 *
 */
public class Solution37 {
    static byte[][] row = new byte[9][9]; //ÿ��1~9�Ƿ���Ա��ù���0û�ù���1�ù���
    static byte[][] col = new byte[9][9]; //ÿ��1~9�Ƿ���Ա��ù���0û�ù���1�ù���
    static byte[][] part = new byte[9][9]; //ÿ��������3*3�Ĺ���1~9�Ƿ���Ա��ù���0û�ù���1�ù���
    static int[] grid = new int[81];   //��¼�ø��ӿ���ѡ������������Ѿ���д���ֵ���ֵΪ������
    static int minOfGrid = 8;
    static int minOfGridLo = -1;

    public static void solveSudoku(char[][] board) {
        initGrid(-1,-1,board);
        addNum(board);
        while(minOfGrid > 1 && minOfGrid != 8){
            addNum2(board);
        }
    }


    /**
     *  ��ʼ������Ԫ���ȡֵ���� grid
     *  i,j��Ϊ����ʱ����ʼ��i�к�j��
     */
    public static void initGrid(int i,int j,char[][] board){
       if( i<0 && j<0){
           row = new byte[9][9];
           col = new byte[9][9];
           part = new byte[9][9];
           grid = new int[81];
           for(int g =0;g<9;g++){
               for(int h =0;h<9;h++){
                   if(board[g][h] <='9' && board[g][h]>'0'){
                       row[g][board[g][h]-'1'] = 1;
                       col[h][board[g][h]-'1'] = 1;
                       part[g/3*3+h/3][board[g][h]-'1'] = 1;
                       grid[g*9+h] = -1;
                   }
               }
           }
           for(int x =0;x<9;x++){
               for(int y =0;y<9;y++){
                   changeGrid(x,y,board);
               }
           }
       }else{
           for(int x=0;x<9;x++){
               if(x!=j){
                   changeGrid(i,x,board);
               }
               if(x!=i){
                   changeGrid(x,j,board);
               }
               if((i/3*3+x/3)!=x && (j/3*3+x%3)!=x){
                   changeGrid((i/3*3+x/3),(j/3*3+x%3),board);
               }
           }
       }
       getMin();
    }

    /**
     * ����ĳ����Ԫ���ȡֵ����
     */
    public static void changeGrid(int i,int j,char[][] board){
        if(board[i][j] == '.'){
            grid[i*9+j]=0;
            for(int k =0;k<9;k++){
                if(row[i][k]==0 && col[j][k] ==0 && part[i/3*3+j/3][k] ==0){
                    grid[i*9+j]++;
                }
            }
        }
    }



    /**
     * ��������ĳ����Ԫ��ֵ�����޸Ķ�Ӧ����������
     */
    public static void useNum(int i,int j,char[][] board,int flag){
        int k=0;
        for(int t = 0;t<9;t++){
            if(row[i][t]==0 && col[j][t]==0 && part[i/3*3+j/3][t]==0 ){
                if(k == flag){
                    board[i][j] = (char)('1'+t);
                    row[i][t]=1;
                    col[j][t]=1;
                    part[i/3*3+j/3][t]=1;
                    grid[i*9+j] = -1;
                    initGrid(i,j,board);
                    break;
                }else if(k<flag){
                    k++;
                }
            }
        }
    }

    /***
     * ��ȡ��С��grid
     */
    public static void getMin(){
        minOfGrid = 8;
        for(int i =0;i<81;i++){
            if(grid[i]>=0 && grid[i] < minOfGrid){
                minOfGrid = grid[i];
                minOfGridLo = i;
            }
        }
    }

    /**
     * �������н�����д1���ĵ�Ԫ��
     */
    public static void addNum(char[][] board){
        while(minOfGrid==1){
            useNum(minOfGridLo/9,minOfGridLo%9,board,0);
        }
    }

    /**
     * ������Ψһȡֵʱ���ϳ�����ֵ����������������ֱ���⿪������
     */
    public static void addNum2(char[][] board) {
        int min = minOfGrid;
        char[][] tmp = new char[9][9];
        copy(tmp,board);
        for (int i = 0; i < min; i++) {
            useNum(minOfGridLo / 9, minOfGridLo % 9, board, i);
            addNum(board);
            if (minOfGrid > 1 && minOfGrid !=8) {
                addNum2(board);
            }
            if (minOfGrid == 0 && i!=min-1) {
                copy(board,tmp);
                initGrid(-1, -1,board);
            }
            if (minOfGrid == 8) {
                break;
            }
        }
    }

    /**
     * �������������ڻָ�����
     */
    public static void copy(char[][] a,char[][] b){
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                a[i][j] = b[i][j];
            }
        }
    }

    public static void main(String[] args) {
//        char[][] a = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] a={{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(a);
        System.out.println("������");
        for (char[] chars : a) {
            for (char aChar : chars) {
                System.out.print(aChar+"��");
            }
            System.out.println();
        }
        System.out.println("����grid��");
        for(int t=0;t<81;t++){
            System.out.print(grid[t]+"��");
            if(t%9==8){
                System.out.println();
            }
        }
    }


    /**
     *
     * @param board
     */
    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') return solveSudokuHelper(board, n + 1, row, col, box);

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) continue;
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) return true;
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}
