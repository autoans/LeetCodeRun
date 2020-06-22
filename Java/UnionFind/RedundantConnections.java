package UnionFind;

/**
 * 684. Redundant Connection
 * @author Katherine
 *
 */
public class RedundantConnections {
    public int[] findRedundantConnection(int[][] edges) {
        // find total number of nodes
        int N = 0;
        for (int[] edge : edges) {
            N = Math.max(edge[0], Math.max(N, edge[1]));
        }
        
        int[] parent = new int[N+1];
        
        // initialize the parent arr to itself
        for (int i = 0 ; i < N+1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0 ; i < edges.length; i++) {
            int m = find(parent, edges[i][0]); // find the parent
            int n = find(parent, edges[i][1]);
            if (m == n)
                return edges[i];
            
            parent[m] = parent[n];
        }
        
        return new int[] {-1,-1};
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        
        return parent[i];
    }
    
    public static void main(String[] args) {
        //int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        int[][]  edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        RedundantConnections rc = new RedundantConnections();
        int[] result = rc.findRedundantConnection(edges);
        System.out.println(result[0]+","+result[1]);
    }

}
