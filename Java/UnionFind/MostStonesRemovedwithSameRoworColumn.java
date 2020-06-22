package UnionFind;

import java.util.HashMap;

/**
 * 947. Most Stones Removed with Same Row or Column
 * Implementation credit: 
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)
 * The maximum stones can be removed = stones number - islands number
 * 
 * a row index, connect two stones on this row
 * a col index, connect two stones on this col.
 *
 */
public class MostStonesRemovedwithSameRoworColumn {
    HashMap<Integer, Integer> h = new HashMap<>();
    int islands = 0;
    
    public int removeStones(int[][] stones) {
        for (int i = 0 ; i < stones.length; i++) {
            union(stones[i][0], ~stones[i][1]);
        }
        
        return stones.length - islands;
    }
    
    public int find(int i) {
        if (h.putIfAbsent(i, i) == null) {
            islands++;
        }
        
        if (i != h.get(i)) {
            h.put(i, find(h.get(i)));
        }
        
        return h.get(i);
    }
   
    public void union(int i, int j) {
        int i_ancestor = find(i);
        int j_ancestor = find(j);
        
        if (i_ancestor != j_ancestor) {
            islands--;
            h.put(i_ancestor, j_ancestor);
        }
    }
    
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn msr = new MostStonesRemovedwithSameRoworColumn();
        System.out.println(msr.removeStones(stones));
    }
}
