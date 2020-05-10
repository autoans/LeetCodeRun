package math;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
if (coordinates.length == 2) return true;
        
        double linear = 0;
        if (coordinates[1][0] - coordinates[0][0]!=0) {
            linear = (coordinates[1][1] - coordinates[0][1])/ (coordinates[1][0] - coordinates[0][0]);
        }

        for (int i = 2; i < coordinates.length; i++) {
            if (linear == 0) {
                if (coordinates[i][1] != coordinates[0][1]) return false;
            } else {
                if (coordinates[i][0] == coordinates[0][0]) return false;
                double currentLinear = 1.0*(coordinates[i][1] - coordinates[0][1])/ (coordinates[i][0] - coordinates[0][0]);

                if (currentLinear!= linear) return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        //int[][] points = {{0,1},{1,3},{-4,-7},{5,11}};
        //int[][] points = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] points2 = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        
        CheckIfItIsAStraightLine ci = new CheckIfItIsAStraightLine();
        System.out.println(ci.checkStraightLine(points2));
    }
}
