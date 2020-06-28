package UnionFind;

import java.util.Arrays;

/**
 * 1319. Number of Operations to Make Network Connected
 * @author Katherine
 *
 */
public class NumberofOperationstoMakeNetworkConnected {
    int totalUnionComponents = 0;
    
    public int makeConnected(int n, int[][] connections) {
        int connectionsNumber = connections.length;
        if (connectionsNumber < n-1) return -1;
        totalUnionComponents = n;
        int[] parent = new int[n];
        
        // initialize the parent arr to -1
        for (int i = 0 ; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] pair : connections) {
            union(parent, pair[0], pair[1]);
        }
        
        return totalUnionComponents-1;
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            //totalUnionCommands++;
            return i;
        }

        return find(parent, parent[i]);
    }
   
    public void union(int[] parent, int i, int j) {
        int i_ancestor = find(parent, i);
        int j_ancestor = find(parent, j);
        
        if (i_ancestor != j_ancestor) {
            totalUnionComponents--;
            parent[i_ancestor] = j_ancestor;
        }
    }
    
    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        //int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
        NumberofOperationstoMakeNetworkConnected nom = new NumberofOperationstoMakeNetworkConnected();
        System.out.println(nom.makeConnected(6, connections));
    }
}
