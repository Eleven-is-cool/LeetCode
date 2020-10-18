package 小米二;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public boolean helper(char[][] board, String word) {

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(backTrack(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean backTrack(char[][] board, String word, int i, int j, int index){
        if (index == word.length())
            return true;
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index) != board[i][j])
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            int n = sc.nextInt();
            //SEE
            char[][] map = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            System.out.println(new Main().helper(map, string));

        }
    }
}
