package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    int[] color;
    int[][] Graph;
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        color = new int[N]; // color with 1 and -1
        Graph = graph;
        
        for (int i = 0 ; i < N; i++) {
            if (!colorAll(i)) return false;
        }
        
        return true;
    }
    
    public boolean colorAll(int i) {
        Queue<Integer> q = new LinkedList<>(); // index, color
        
        if (color[i] == 0)
            color[i] = 1;

        q.add(i);
        
        while (!q.isEmpty()) {
            int sourceNode = q.poll();
            int targetColor = color[sourceNode] * -1;
            
            int[] adjacents = Graph[sourceNode];
            
            for (int connectNode : adjacents) {
                if (color[connectNode] == color[sourceNode]) return false;
                if (color[connectNode] == 0) {
                    color[connectNode] = targetColor;
                    q.add(connectNode);
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        IsGraphBipartite igb = new IsGraphBipartite();
        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        System.out.println(igb.isBipartite(graph));
    }
}
