package LeetcodeChallenge;

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (m > n) {
            n = n & (n-1);
        }
        
        return n;
    }
}
