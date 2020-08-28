package 岛屿数量;

public class Solution {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length==0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int res = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] != '1')
            return;
        grid[i][j] = '2';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
