package 岛屿周长;

public class Solution {
    // 方法一：直接遍历，遇到1进去，加4，在判断上边左边是否也是1，是的话减2
    // 方法二：dfs
    // 通过示例图可以发现：
    // 1. 每遍历到一个水域，周长加一，
    // 2. 超出边界，周长加一
    // 3. 走过一个岛屿，周长加零
    int row;
    int col;
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length==0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, int i, int j){
        if (i<0 || i>=row || j<0 || j>=col)
            return 1;
        if (grid[i][j] == 0)
            return 1;
        if (grid[i][j] == 2)
            return 0;
        grid[i][j] = 2;
        return dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }
}
