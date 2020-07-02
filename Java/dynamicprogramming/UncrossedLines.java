package dynamicprogramming;

public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = B.length;
        // dp(i,j) - how many lines A[0:i], B[0:j] are max crossed
        int[] currentRow = new int[n + 1];

        for (int i = 1; i <= A.length; i++) {
            int[] previousRow = currentRow;
            currentRow = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                currentRow[j] = (A[i - 1] == B[j - 1] ? previousRow[j - 1] + 1
                        : Math.max(previousRow[j], currentRow[j - 1]));
            }
        }

        return currentRow[n];
    }

    public static void main(String[] args) {
        int[] A = { 1, 10, 9, 10 };
        int[] B = { 1, 10, 9, 10 };

        UncrossedLines mu = new UncrossedLines();

        System.out.println(mu.maxUncrossedLines(A, B));
    }
}
