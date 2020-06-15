package dfs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 207. Course Schedule
 * @author Katherine
 *
 */
public class CourseSchedule {
    HashMap<Integer, ArrayList<Integer>> courses = new HashMap<>();
    int[] color;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        color = new int[numCourses]; // default: all 0
        
        // set up all the edges in the graph in courses
        for (int i = 0 ; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            if (!courses.containsKey(pre))
                courses.put(pre, new ArrayList<Integer>());
            courses.get(pre).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }
    
    public boolean dfs(int i) {
        if (color[i] != 0) return color[i] == 1;
        
        color[i] = 2;
        
        ArrayList<Integer> arr = courses.get(i);
        if (arr != null) // not have any outgoing edges
        {
            for(int j = 0 ; j < arr.size(); j++) {
                if (!dfs(arr.get(j))) return false;
            }
        }
        
        color[i] = 1;
        
        return true;
    }
    
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}, {0, 1}};
        
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(2, prerequisites));
    }
}
