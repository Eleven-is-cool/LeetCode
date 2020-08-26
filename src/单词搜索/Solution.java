package 单词搜索;

public class Solution {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(backTrack(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board, String word, int i, int j, int index){
        if (index == word.length())
             return true;
        if (i<0 || i>=row || j<0 || j>=col || word.charAt(index) != board[i][j])
             return false;

        char cur = board[i][j];
        cur = '#';
        if(backTrack(board, word, i+1, j, index+1))
            return true;
        if(backTrack(board, word, i-1, j, index+1))
            return true;
        if(backTrack(board, word, i, j+1, index+1))
            return true;
        if(backTrack(board, word, i, j-1, index+1))
            return true;
        board[i][j] = cur;
        return false;
    }
}
