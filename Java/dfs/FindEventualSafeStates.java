package dfs;

import java.util.ArrayList;
import java.util.List;

import utility.IO;

/**
 * 802. Find Eventual Safe States
 * 
 * @author Katherine
 *
 */
public class FindEventualSafeStates {
    int[] color;
    boolean[] cyclic;
    int[][] Graph;
    int N;

    // credit: 
    // https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        N = graph.length;
        Graph = graph;
        
        color = new int[N];
        
        for(int i = 0;i < N;i++){
            if(dfs(i)) res.add(i);
        }
        
        return res;
    }
    
    // false - unsafe - cycle
    public boolean dfs(int i) {
        if (color[i] != 0) return color[i] == 1;
        
        color[i] = 2;
        
        for(int j : Graph[i]) {
            if (!dfs(j)) return false;
        }
        
        color[i] = 1;
        
        return true;
    }
    
    // Time limit exceeded
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        N = graph.length;
        
        cyclic = new boolean[N];
        Graph = graph;

        for (int i = 0; i < N; i++) {
            if (cyclic[i])
                continue;

            boolean[] hasVisited = new boolean[N];
            hasVisited[i] = true;
            dfs2(i, hasVisited);
        }

        List<Integer> safeNodes = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (!cyclic[i])
                safeNodes.add(i);
        }

        return safeNodes;
    }

    public void dfs2(int i, boolean[] hasVisited) {
        int[] arr = Graph[i];

        for (int j : arr) {
            if (hasVisited[j]) {
                cyclic[j] = true;
                
                // mark all the nodes in this loop as cyclic
                for (int t = 0 ; t < N; t++) {
                    cyclic[t] = hasVisited[t] || cyclic[t];
                }
                
                continue;
            }
            
            hasVisited[j] = true;
            dfs2(j, hasVisited.clone());
            hasVisited[j] = false;
        }
    }

    public static void main(String[] args) {
        //int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} }; //2 4 5 6 
        
        int[][] graph = {{0},{2,3,4},{3,4},{0,4},{}}; //4

        FindEventualSafeStates fes = new FindEventualSafeStates();
        List<Integer> safeNodes = fes.eventualSafeNodes(graph);
        IO.printArrayList(safeNodes);
    }
}
