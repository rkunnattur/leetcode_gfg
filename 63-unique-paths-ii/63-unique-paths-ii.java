class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        return uniquePathsWithObstaclesIOpt1(obstacleGrid);
    }
    
    public int uniquePathWithObstaclesI(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length, colLen = obstacleGrid[0].length;
        int[][] paths = new int[rowLen][colLen];
        
        for(int r = 0; r < rowLen; r++) {
            if(obstacleGrid[r][0] == 1) break;
            paths[r][0] = 1;
        }
        
        for(int c = 0; c < colLen; c++) {
            if(obstacleGrid[0][c] == 1) break;
            paths[0][c] = 1;
        }
        
        for(int r = 1; r < rowLen; r++) {
            for(int c = 1; c < colLen; c++) {
                if(obstacleGrid[r][c] == 1) continue;
                paths[r][c] = paths[r-1][c] + paths[r][c-1];
            }
        }
        
        return paths[rowLen-1][colLen-1];
    }
    
    // no extra space
    public int uniquePathsWithObstaclesIOpt1(int[][] obstacleGrid) {
            int rowLen = obstacleGrid.length;
            int colLen = obstacleGrid[0].length;
    
            obstacleGrid[0][0] ^= 1;
        
            for(int r = 1; r<rowLen; r++){
                obstacleGrid[r][0] = obstacleGrid[r][0] == 1 ? 0 : obstacleGrid[r-1][0];
            }
            
            for(int c = 1; c<colLen; c++){
                obstacleGrid[0][c] = obstacleGrid[0][c] == 1 ? 0 : obstacleGrid[0][c-1] ;
            }
        
            for(int r = 1; r < rowLen; r++){
                for(int c = 1; c < colLen; c++){
                    obstacleGrid[r][c] = (obstacleGrid[r][c] == 1) ? 0 : obstacleGrid[r-1][c]+obstacleGrid[r][c-1];
                }
            }
        
            return obstacleGrid[rowLen-1][colLen-1];
        }
}