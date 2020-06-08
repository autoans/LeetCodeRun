package dfs;

/**
 * 1254. Number of Closed Islands
 * @author Katherine
 *
 */
public class ClosedIslands {
    int[][] islands;
    public int closedIsland(int[][] grid) {
        islands = grid;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // change all the connect to edge 0 to 1
        for (int j = 0 ; j < n; j++) {
            dfs(m, n, 0, j);
            dfs(m, n, m-1, j);
        }
        
        for (int i = 0; i < m; i++) {
            dfs(m, n, i, 0);
            dfs(m, n, i, n-1);
        }
        
        int totalIslands = 0;

        // calculate all the islands
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    totalIslands++;
                    dfs(m, n, i, j);
                }
            }
        }
       
        return totalIslands;
    }
    
    public void dfs(int m, int n, int i, int j) {
        if (i < 0 || i >=m || j < 0 || j >= n || islands[i][j] == 1)
            return;
        
        // change 0 to 1 in place
        islands[i][j] = 1;
        
        dfs(m, n, i+1, j);
        dfs(m, n, i-1, j);
        dfs(m, n, i, j+1);
        dfs(m, n, i, j-1);
    }
    
    public static void main(String[] args) {
        ClosedIslands ci = new ClosedIslands();
        int[][] grid = {{1,1,1,1,1,1,1},
        {1,0,0,0,0,0,1},
        {1,0,1,1,1,0,1},
        {1,0,1,0,1,0,1},
        {1,0,1,1,1,0,1},
        {1,0,0,0,0,0,1},
        {1,1,1,1,1,1,1}};
        System.out.println(ci.closedIsland(grid));
    }
}
