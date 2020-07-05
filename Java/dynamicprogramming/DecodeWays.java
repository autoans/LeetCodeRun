package dynamicprogramming;

/**
 * 91. Decode Ways
 * @author Katherine
 *
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];

        char[] sch = s.toCharArray();
        dp[1] = sch[0] == '0'? 0 : 1;
        dp[0] = 1;
        
        for (int i = 2 ; i < len+1; i++) {
            int twoDigitsNumber = Character.getNumericValue(sch[i-1]) + Character.getNumericValue(sch[i-2]) * 10;
            int oneDigitsNumber = Character.getNumericValue(sch[i-1]);
            
            if (oneDigitsNumber > 0)
                dp[i] += dp[i-1];
            
            if (twoDigitsNumber <= 26 && twoDigitsNumber >= 10)
                dp[i] +=dp[i-2];

        }
        
        return dp[len];
    }
    
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("10"));
    }
}
