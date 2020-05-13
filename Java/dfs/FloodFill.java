package dfs;

public class FloodFill {
    int[][] newImage;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        newImage = image;
        floorFillHelper(sr, sc, m, n, newColor, currentColor);
        return newImage;
    }
    
    public void floorFillHelper(int x, int y, int m, int n, int newColor, int color) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        
        if (newImage[x][y] == newColor) return; // already changed
        if (newImage[x][y] == color) {
            newImage[x][y] = newColor;
            floorFillHelper(x-1, y, m, n, newColor, color);
            floorFillHelper(x+1, y, m, n, newColor, color);
            floorFillHelper(x, y-1, m, n, newColor, color);
            floorFillHelper(x, y+1, m, n, newColor, color);
        }
    }
    
    public static void main(String[] args) {
        int[][] colors = {{1,1,1},{1,1,0},{1,0,1}};
        
        FloodFill ff = new FloodFill();
        colors = ff.floodFill(colors, 1, 1, 2);
        
        for (int i = 0 ; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                System.out.print(colors[i][j]+" ");
            }
            System.out.println();
        }
    }
}
