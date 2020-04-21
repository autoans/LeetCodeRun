package binarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        // first find the row the target is in
        int low = 0;
        int high = m-1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (target > matrix[mid][n-1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int rowIndex = low;
        
        low = 0; high = n-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (target > matrix[rowIndex][mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        
        return matrix[rowIndex][low] == target? true: false;
    }
    
    public static void main(String[] args) {
        SearchA2DMatrix sa = new SearchA2DMatrix();
        //int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        int[][] matrix = {{}};
        System.out.println(sa.searchMatrix(matrix, 1));
    }
}
