package graph;

/**
 * 997. Find the Town Judge
 * @author https://leetcode.com/problems/find-the-town-judge/discuss/242938/JavaC%2B%2BPython-Directed-Graph
 *
 */
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        
        for (int i = 0 ; i < trust.length; i++) {
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }
        
        for (int i = 1; i < N+1; i++) {
            if (count[i] == N-1) return i;
        }
        
        return -1;
    }
}
