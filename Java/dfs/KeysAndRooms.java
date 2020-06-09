package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    boolean[] canVisit;
    List<List<Integer>> keysAndRooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        canVisit = new boolean[N];
        keysAndRooms = rooms;
        for (int i = 0 ; i < N; i++) {
            // Skip visiting a room if we have already visited it, or if we cannot access it
            if (i != 0 && !canVisit[i])
                continue;
            
            dfs(i, N);
        }
        
        canVisit[0] = true;
        for(boolean b : canVisit) if(!b) return false;
        return true;
    }
    
    public void dfs(int i, int N) {
        if (i < 0 || i >= N || canVisit[i]) return;
        
        List<Integer> arr = keysAndRooms.get(i);
        canVisit[i] = true;
        
        for (int j : arr) {
            dfs(j, N);
        }
    }
    
    public static void main(String[] args) {
        //[[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> keys = new ArrayList<List<Integer>>();
        //TODO -- [[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]] failed!!!
        List<Integer> arr0 = new ArrayList<>(); arr0.add(1); arr0.add(3);
        List<Integer> arr1 = new ArrayList<>(); arr1.add(3); arr1.add(0); arr1.add(1);
        List<Integer> arr2 = new ArrayList<>(); arr2.add(2); 
        List<Integer> arr3 = new ArrayList<>(); arr3.add(0);

        keys.add(arr0);keys.add(arr1);keys.add(arr2);keys.add(arr3);
        KeysAndRooms kr = new KeysAndRooms();
        System.out.println(kr.canVisitAllRooms(keys));
    }
}
