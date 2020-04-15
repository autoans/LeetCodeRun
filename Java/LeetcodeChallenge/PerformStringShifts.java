package LeetcodeChallenge;
/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 

Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
 * @author Katherine
 *
 */
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        // The basic idea of this approach is, consider the string as an array, each character is an element in the array
        // To keep track of a ring stored in an array, you only need to track the starting index of the ring.
        int head = 0; // result string starting from this index
        int len = s.length();
        
        for (int i = 0 ; i < shift.length; i++) {
            boolean shiftLeft = (shift[i][0] == 0);
            int shiftSteps = shift[i][1];
            shiftSteps = shiftSteps % len;
            
            if (shiftLeft) {
                head += shiftSteps;
                if (head >= len) head -= len;
            } else {
                head -= shiftSteps;
                if (head < 0) head += len;
            }
        }
        
        return s.substring(head, len) + s.substring(0, head);
    }
    
    public static void main(String[] args) {
        PerformStringShifts pss = new PerformStringShifts();
        int[][] shift = {{0,1}, {1,2}};
        System.out.println(pss.stringShift("abc", shift) + " == should be cab");
        System.out.println("abc".substring(0, 0));
        int[][]  shift2 = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(pss.stringShift("abcdefg", shift2) + " == should be efgabcd");
    }
}
