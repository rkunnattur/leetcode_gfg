class Solution {
    public boolean removeOnes(int[][] grid) {
        int rowlen = grid.length, collen = grid[0].length;
        for(int r = 0; r < rowlen; r++) {
            if(grid[0][0] == grid[r][0]) {
                for(int c = 0; c < collen; c++) {
                    if(grid[0][c] != grid[r][c]) return false;
                }
            } else {
                for(int c = 0; c < collen; c++) {
                    if(grid[0][c] == grid[r][c]) return false;
                }
            }
        }
        
        return true;
    }
}