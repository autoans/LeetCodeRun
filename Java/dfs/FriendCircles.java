package dfs;

public class FriendCircles {
    boolean[] visited;
    int Circles;
    
    public int findCircleNum(int[][] M) {
        int N = M.length;
        visited = new boolean[N];
        
        for (int i = 0 ; i < N; i++) {
            if (!visited[i]) {
                dfs(M, i);
                Circles++;
            }
            
        }
        
        return Circles;
    }

    public void dfs(int[][] M, int i) {
        for (int j = 0 ; j < M.length; j++) {
            if (i == j) continue;
            
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                dfs(M, j);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] friends = {{1,1,0},
        {1,1,0},
        {0,0,1}};
        
        FriendCircles fc = new FriendCircles();
        System.out.println(fc.findCircleNum(friends));
    }
    
}
