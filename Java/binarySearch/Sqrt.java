package binarySearch;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        
        int low = 1;
        int high = x;
        
        while (low < high) {
            int mid = low + (high-low)/2;
            
            if (mid > x / mid) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        return low-1;
    }
    
    public int sqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
          int m = l + (r - l) / 2;
          if (m > x / m) {
            r = m - 1;
          } else {
            l = m + 1;
          }
        }
        return r;
    }
    
    public static void main(String[] args) {
        Sqrt si = new Sqrt();
        //System.out.println(si.mySqrt(16));
        System.out.println(si.mySqrt(214739559));
        System.out.println(si.sqrt(214739559));
    }
}
