package binarySearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        
        return start;
    }
    
    public boolean isBadVersion(int version) {
        if (version <= 3) return false;
        return true;
    }
    
    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        System.out.println(fbv.firstBadVersion(5));
    }
}
