package bfs;

import java.util.LinkedList;
import java.util.Queue;

import utility.IO;

/**
 * 542. 01 Matrix
 * @author credit: https://leetcode.com/problems/01-matrix/discuss/101021/Java-Solution-BFS
 *
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (matrix[i][j] == 0)
                    q.add(new int[] {i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int[] d : dirs) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || matrix[x1][y1] <= matrix[x][y]+1) {
                    continue;
                }
                matrix[x1][y1] = matrix[x][y] + 1;
                q.add(new int[] {x1, y1});
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},
                          {0,1,0},
                          {1,1,1}};
        ZeroOneMatrix zm = new ZeroOneMatrix();
        IO.print2DArray(zm.updateMatrix(matrix));
    }
}
