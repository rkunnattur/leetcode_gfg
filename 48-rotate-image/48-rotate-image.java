class Solution {
    public void rotate(int[][] matrix) {
         int n = matrix.length; // since its n*n matrix  we dont need to consider column as such both are same

         for (int i = 0; i< ((n+1)>>1); i++) {
             for (int j = 0; j< (n>>1); j++) {
                 int temp = matrix[i][j];
                 matrix[i] [j] = matrix[n-1-j][i];
                 matrix[n-1-j] [i] = matrix[n-1-i][n-1-j];
                 matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                 matrix[j][n-1-i] = temp;
             }
         }
    }
}