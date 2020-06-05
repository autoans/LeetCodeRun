package dfs;

/**
 * 1020. Number of Enclaves
 * @author Katherine
 *
 */
public class NumberOfEnclaves {
    int originalBoard[][];
    
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) return 0;
        originalBoard = A;
        
        int m  = A.length;
        int n = A[0].length;
        
        for (int i = 0 ; i < m; i++) {
            dfs(i, 0, m, n, 1, 2);
            dfs(i, n-1, m, n, 1, 2);
        }
        
        for (int j = 0; j < n; j++) {
            dfs(0, j, m, n,1,2);
            dfs(m-1, j, m, n, 1, 2);
        }
            
        int enclaves = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (originalBoard[i][j] == 1)
                    enclaves++;
            }
        }
        
        return enclaves;
    }
    
    public void dfs(int x, int y, int m, int n, int oldCh, int newCh) {
        if (x <0 || x >= m || y < 0 || y >= n)
            return;
        
        if (originalBoard[x][y] == oldCh)
            originalBoard[x][y] = newCh;
        else
            return;
        
        dfs(x-1, y, m, n, oldCh, newCh);
        dfs(x+1, y, m, n, oldCh, newCh);
        dfs(x, y-1, m, n, oldCh, newCh);
        dfs(x, y+1, m, n, oldCh, newCh);
    }
}
