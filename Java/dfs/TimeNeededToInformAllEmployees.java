package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1376. Time Needed to Inform All Employees
 * @author Katherine
 *
 */
public class TimeNeededToInformAllEmployees {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    public int numOfMinutesIterative(int n, int headID, int[] manager, int[] informTime) {
        int maxInformMin = 0;
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        
        for (int i = 0 ; i < manager.length; i++) {
            if (!m.containsKey(manager[i]))
                m.put(manager[i], new ArrayList<Integer>());
            m.get(manager[i]).add(i);
        }
        
        // Top to bottom calculate all the inform time
        // employees queue keep record of reaching this employ taking time
        // informTimes keep record of the time
        // Using two queues since there's no built in Tuple in Java
        Queue<Integer> employees = new LinkedList<>();
        Queue<Integer> informTimes = new LinkedList<>();
        
        employees.add(headID); informTimes.add(informTime[headID]);
        
        while (!employees.isEmpty()) {
            int currentManager = employees.poll();
            int currentInformTime = informTimes.poll();
            if (!m.containsKey(currentManager)) {
                maxInformMin = Math.max(maxInformMin, currentInformTime);
                continue;
            }
            
            for (int i = 0 ; i < m.get(currentManager).size(); i++) {
                if (!m.containsKey(m.get(currentManager).get(i))) {
                    // Reaching the last employee in a hierachy
                    maxInformMin = Math.max(maxInformMin, currentInformTime);
                } else {
                    employees.add(m.get(currentManager).get(i)); informTimes.add(informTime[m.get(currentManager).get(i)] + currentInformTime);
                }
            }
        }
        
        return maxInformMin;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0 ; i < manager.length; i++) {
            if (!map.containsKey(manager[i]))
                map.put(manager[i], new ArrayList<Integer>());
            map.get(manager[i]).add(i);
        }
        
        return dfsHelper(headID, informTime);
    }
    
    public int dfsHelper(int currentManager, int[] informTime) {
        if (!map.containsKey(currentManager))
            return 0;
        
        int currentManagerDirectsMax = 0;
        ArrayList<Integer> currentManagerDirects = map.get(currentManager);
        for (int j = 0; j < currentManagerDirects.size(); j++) {
            currentManagerDirectsMax = Math.max(currentManagerDirectsMax, dfsHelper(currentManagerDirects.get(j), informTime));
        }
        
        return informTime[currentManager] + currentManagerDirectsMax;
    }
        
    public static void main(String[] args) {
        TimeNeededToInformAllEmployees tn = new TimeNeededToInformAllEmployees();
        int[] manager = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = {0,213,0,253,686,170,975,0,261,309,337};
        //int[] manager = {-1};
        //int[] informTime = {0};
        System.out.println(tn.numOfMinutesIterative(11, 4, manager, informTime));
    }
}
