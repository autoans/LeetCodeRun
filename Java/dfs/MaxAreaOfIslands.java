package dfs;

public class MaxAreaOfIslands {
    int currentIslandArea = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxAreaOfIslands = 0;
        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfsIslands(grid, i, j, 0);
                    maxAreaOfIslands = Math.max(maxAreaOfIslands, currentIslandArea);
                    currentIslandArea = 0;
                }
            }
        }
        
        return maxAreaOfIslands;
    }
    
    public void dfsIslands(int[][] grid, int i, int j, int area) {
        // For any given i, j
        // check all '1's connected to the grid[i][j]
        if (i >= grid.length || j < 0 || i < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        
        // mark grid as 0, since it's visited
        grid[i][j] = 0;
        currentIslandArea++;
        dfsIslands(grid, i+1, j, area);
        dfsIslands(grid, i, j+1, area);
        dfsIslands(grid, i, j-1, area);
        dfsIslands(grid, i-1, j, area);
    }
    
    public static void main(String[] args) {
        MaxAreaOfIslands ni = new MaxAreaOfIslands();
//        char[][] grid = {{'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        int[][] grid = {
                //{1,1,1},
                {0,1,0},
                {1,1,1}};
        System.out.println(ni.maxAreaOfIsland(grid));
    }
}
