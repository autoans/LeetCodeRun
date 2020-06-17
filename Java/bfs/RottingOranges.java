package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * @author Katherine
 *
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int maxPathLength = 0;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0; // length of path
                    q.add(new int[] {i, j});
                }
                else if (grid[i][j] == 0) grid[i][j] = -1;
                else if (grid[i][j] == 1) grid[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            int x = tomato[0]; int y = tomato[1];
            
            for (int[] d : dirs) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == -1 || grid[x1][y1] <= grid[x][y] + 1) 
                    continue;
                grid[x1][y1] = grid[x][y] + 1;
                maxPathLength = Math.max(maxPathLength, grid[x1][y1]);
                q.add(new int[] {x1, y1});
            }
        }
        
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
            }
        }
        
        return maxPathLength;
    }
    
    public static void main(String[] args) {
        //int[][] matrix = {{0,1},{1,0}};
//        int[][] matrix = {{0,0,0},
//                          {1,1,0},
//                          {1,1,0}};
//        int[][] matrix = {
//                        {0,0,1,0},
//                        {1,0,1,0},
//                        {1,1,0,1},
//                        {0,0,0,0}};
        int[][] matrix = {{2,1,1},{0,1,1},{1,0,1}};
        RottingOranges ro = new RottingOranges();
        System.out.println((ro.orangesRotting(matrix)));
    }
}
