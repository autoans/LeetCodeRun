package LeetcodeChallenge;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0 ; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    totalIslands++;
                    dfsIslands(grid, i, j);
                }
            }
        }
        
        return totalIslands;
    }
    
    public void dfsIslands(char[][] grid, int i, int j) {
        // For any given i, j
        // check all '1's connected to the grid[i][j]
        if (i >= grid.length || j < 0 || i < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        
        // mark grid as 0, since it's visited
        grid[i][j] = '0';
        dfsIslands(grid, i+1, j);
        dfsIslands(grid, i, j+1);
        dfsIslands(grid, i, j-1);
        dfsIslands(grid, i-1, j);
    }
    
    public static void main(String[] args) {
        NumberOfIslands ni = new NumberOfIslands();
//        char[][] grid = {{'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}};
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};
        System.out.println(ni.numIslands(grid));
    }
}
