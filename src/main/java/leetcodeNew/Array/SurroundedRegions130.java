package leetcodeNew.Array;

/**
 * Created by baidu on 16/8/5.
 */
public class SurroundedRegions130 {
    public int col = 0;
    public int row = 0;
    public void solve(char[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        for(int i = 0 ; i < row;i++){   //行
            dfs(board,i,0);
            dfs(board, i, col - 1);
        }
        for(int i = 0 ; i < col;i++){   //行
            dfs(board,0,i);
            dfs(board, row-1, i);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else
                    board[i][j]='X';
            }
        }

    }

     private void dfs(char[][] board, int row,int col){
        if(board[col][row]=='O'){
            board[col][row]='*';
        }
        if(row>1){
            dfs(board,row-1,col);
        }
        if(col>1){
            dfs(board,row,col-1);
        }
        if (row < row - 1) {
            dfs(board, row + 1, col);
        }
        if (col < col - 1) {
            dfs(board, row, col + 1);
        }
    }

}
