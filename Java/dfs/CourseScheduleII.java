package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import utility.IO;

/**
 * 210. Course Schedule II
 * @author Katherine
 *
 */
public class CourseScheduleII {
    HashMap<Integer, ArrayList<Integer>> courses = new HashMap<>();
    boolean[] hasVisited;
    LinkedList<Integer> courseOrder = new LinkedList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        hasVisited = new boolean[numCourses]; // default: all 0
        
        // set up all the edges in the graph in courses
        for (int i = 0 ; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            if (!courses.containsKey(pre))
                courses.put(pre, new ArrayList<Integer>());
            courses.get(pre).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }

        return courseOrder.stream().mapToInt(i->i).toArray();
    }
    
    public boolean dfs(int i) {
        if (hasVisited[i]) return courseOrder.contains(i); //if not added into list yet, there's cycle
        
        hasVisited[i] = true;
        
        ArrayList<Integer> arr = courses.get(i);
        if (arr != null)
        {
            for(int j = 0 ; j < arr.size(); j++) {
                if (!dfs(arr.get(j))) return false;
            }
        } 
        
        // Add to the beginning
        // No outgoing edges or all the out going target nodes have been visited
        courseOrder.add(0, i);
        
        return true;
    }
    
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        
        CourseScheduleII cs = new CourseScheduleII();
        IO.printArray(cs.findOrder(4, prerequisites));
    }
}
