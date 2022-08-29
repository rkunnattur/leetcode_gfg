
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int islands = 0 ;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    islands += 1;
                    countIslands(grid, visited, i, j);
                }
            }
        }
        return islands;
    }
    
    public boolean canGo(char[][] grid, boolean[][] visited, int row, int col){
        int rows = grid.length, cols = grid[0].length;        
        return 0 <= row && row < rows && 0<=col && col<cols 
            && grid[row][col] == '1' && !visited[row][col];
    }
    
    public void countIslands(char[][] grid, boolean[][] visited, int row, int col){
        
				if(!canGo(grid, visited, row, col)) return; 
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        visited[row][col] = true;
        
        for(int i=0; i<4; i++){
            int x = row + dx[i], y = col + dy[i];
            countIslands(grid, visited, x, y);
        }
    }
}