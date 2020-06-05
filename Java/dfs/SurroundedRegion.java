package dfs;

/**
 * 130. Surrounded Regions
 * @author Katherine
 *
 */
public class SurroundedRegion {
    char originalBoard[][];
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        // first do dfs flip all the 'O' close to the border to 'T'
        originalBoard = board;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0 ; i < m; i++) {
            dfs(i, 0, m, n, 'O', 'Y');
            dfs(i, n-1, m, n, 'O', 'Y');
        }
        
        for (int j = 0; j < n; j++) {
            dfs(0, j, m, n,'O','Y');
            dfs(m-1, j, m, n, 'O', 'Y');
        }
            
        // then flip all the inner 'O' to X
        // flip all the 'T' to O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (originalBoard[i][j] == 'O')
                    originalBoard[i][j] = 'X';
                
                if (originalBoard[i][j] == 'Y')
                    originalBoard[i][j] = 'O';
            }
        }
        
        board = originalBoard;
    }
    
    public void dfs(int x, int y, int m, int n, char oldCh, char newCh) {
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
    
    public static void main(String[] args) {
        char[][] board = {{'X','O','X'},
                          {'O','X','O'},
                          {'X','O','X'},
                          {'X','O','X'}};
        //[["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]

        SurroundedRegion sr = new SurroundedRegion();
        sr.solve(board);
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            
            System.out.println();
        }
    }
}
