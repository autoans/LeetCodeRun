package dynamicprogramming;

import LeetcodeChallenge.MaximalSquare;

/**
 * Count Square Submatrices with All Ones

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * @author Katherine
 *
 */
public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        // dp[i][j] represents the length of the square which lower right corner is located at (i, j).
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for (int i = 1 ; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }
                
                result += dp[i][j];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes ms = new CountSquareSubmatriceswithAllOnes();
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}};
        
        System.out.println(ms.countSquares(matrix));
    }
}
