package 岛屿的最大面积;

public class Solution {
    int row;
    int col;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length==0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int max = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 1){
                    int curArea = 0;
                    curArea = dfs(grid, i, j);
                    max = Math.max(max, curArea);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j){
        if (i<0 || i>=row || j<0 || j>=col || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        return 1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);

    }
}
