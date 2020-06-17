package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. As Far from Land as Possible
 * @author Katherine
 *
 */
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int distance = -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (grid[i][j] == 0)
                    grid[i][j] = Integer.MAX_VALUE;
                else {
                    grid[i][j] = 0;
                    q.add(new int[] {i, j});
                }
            }
        }
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int[] d: directions) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] <= grid[x][y] + 1) 
                    continue;
                grid[x1][y1] = grid[x][y] + 1;
                distance = Math.max(distance, grid[x1][y1]);
                q.add(new int[] {x1, y1});
            }
        }
        
        return distance;
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
        int[][] matrix = {{1,0,0},{0,0,0},{0,0,0}};
        AsFarFromLandAsPossible af = new AsFarFromLandAsPossible();
        System.out.println(af.maxDistance(matrix));
    }
}
