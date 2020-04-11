package LeetcodeChallenge;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 * @author Katherine
 *
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] s_arr = S.toCharArray();
        char[] t_arr = T.toCharArray();
        int s_backspace = 0;
        int t_backspace = 0;
        int i = s_arr.length - 1;
        int j = t_arr.length -1;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s_arr[i] == '#' || s_backspace > 0)) {
                if (s_arr[i] == '#') s_backspace++;
                else s_backspace--;
                
                i--;
            }
            
            while (j >= 0 && (t_arr[j] == '#' || t_backspace > 0)) {
                if (t_arr[j] == '#') t_backspace++;
                else t_backspace--;
                
                j--;
            }

            if (i >= 0 && j >= 0 && s_arr[i] != t_arr[j]) return false;
            else if ((i >= 0) != (j >= 0)) return false;
            
            i--; j--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println("true == "+bsc.backspaceCompare("ab#c", "ad#c"));
        System.out.println("true == "+bsc.backspaceCompare("ab###", "c#d#"));
        System.out.println("true == "+bsc.backspaceCompare("a##c", "#a#c"));
        System.out.println("false == "+bsc.backspaceCompare("a#c", "b"));
        System.out.println("true == "+bsc.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
