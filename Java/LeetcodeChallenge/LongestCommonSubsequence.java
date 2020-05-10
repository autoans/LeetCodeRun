package LeetcodeChallenge;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        //DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
        int l1 = text1.length();
        int l2 = text2.length();
        
        int[][] dp = new int[l1][l2];
        int maxLength = 0;
        
        for (int i = 0 ; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (text1.charAt(i) == text2.charAt(j)? 1: 0);
                    if (i != 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                    } else if (j != 0) {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i][j]);
                    }
                } else {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                    
                }
                
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestCommonSubsequence lcb = new LongestCommonSubsequence();
//        String text1= "abcde";
//        String text2 = "ace";
        String text1 = "abc";
        String text2 = "def";
        System.out.println(lcb.longestCommonSubsequence(text1, text2));
    }
}
