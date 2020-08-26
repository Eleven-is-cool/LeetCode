package N皇后;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0)
            return null;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(board, n, 0);
        return res;
    }
    public void backtrack(char[][] board, int n, int row){
        if (board.length == row){
            res.add(charToString(board));
            return;
        }
        for (int col=0;col<n;col++){
            if (!isValid(board, row, col, n))
                continue;
            board[row][col] = 'Q';
            backtrack(board, n,row+1);
            board[row][col] = '.';
        }
    }
    public List<String> charToString(char[][] array){
        List<String> result = new ArrayList<>();
        for (char[] chars:array){
            result.add(String.valueOf(chars));
        }
        return result;
    }
    public boolean isValid(char[][] board, int row, int col, int n){
        // 正上方
        for (int i = 0; i < row; i++){
            if (board[i][col] == 'Q')
                return false;
        }
        // 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (board[i][j] == 'Q')
                return false;
        }
        // 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
