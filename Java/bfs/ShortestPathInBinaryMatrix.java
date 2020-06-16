package bfs;

import java.util.LinkedList;
import java.util.Queue;

import utility.IO;

/**
 * 1091. Shortest Path in Binary Matrix
 * @author Katherine
 *
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int shortestPath = -1;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (i == 0 && j == 0)
                        grid[i][j] = 1;
                    else
                        grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        q.add(new int[] {0,0});
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
                    {-1, -1}, {-1,1}, {1,-1}, {1,1}};
        
        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == m-1 && y == n-1) shortestPath = grid[x][y];
            
            for (int[] d : dirs) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1 ||grid[x1][y1] <= grid[x][y]+1) {
                    continue;
                }
                
                grid[x1][y1] = grid[x][y] + 1;
                q.add(new int[] {x1, y1});
            }
        }
        
        return shortestPath < 0? -1: shortestPath;
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
        int[][] matrix = {{0}};
        ShortestPathInBinaryMatrix sp = new ShortestPathInBinaryMatrix();
        System.out.println((sp.shortestPathBinaryMatrix(matrix)));
    }
}
