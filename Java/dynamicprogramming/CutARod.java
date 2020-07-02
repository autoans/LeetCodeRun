package dynamicprogramming;

/**
 * Algorithm 3rd edition, Chapter 15.1
 * @author Katherine
 *
 */
public class CutARod {
    public int cutARod(int[] price, int n) {
        int[] r = new int[n+1];

        for (int i = 1 ; i < n + 1; i++) {
            int currentMax = Integer.MIN_VALUE;
            
            for (int j = 0 ; j < i; j++) {
                currentMax = Math.max(currentMax, r[i - j - 1] + price[j]);
            }
            
            r[i] = currentMax;
        }
        
        return r[n];
    }
    
    public static void main(String[] args) {
        CutARod c = new CutARod();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20, 24, 30}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is " + 
                c.cutARod(arr, size)); 
    }
}
