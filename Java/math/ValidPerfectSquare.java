package math;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int end = num/2;
        int start = 1;
        
        while (start <= end) {
            int mid = (end - start)/2 + start;
            
            if (mid * mid == num) {
                return true;
            } else if (mid < num/mid){
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        ValidPerfectSquare vp = new ValidPerfectSquare();
        
        System.out.println(vp.isPerfectSquare(808201));
    }
}
