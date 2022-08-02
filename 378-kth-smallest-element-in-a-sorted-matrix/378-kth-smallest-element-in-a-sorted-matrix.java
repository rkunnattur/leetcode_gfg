class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        return kthSmallestBS(matrix, k);
    }
    
    
    public int kthSmallestBS(int[][] matrix, int k) {
        int rowLen = matrix.length, colLen = matrix[0].length, indexOfK = -1;
        
        int start = matrix[0][0], end = matrix[rowLen-1][colLen-1];
        while(start <= end) {
            int mid = start + ((end - start)>>1);
            if(computeCount(matrix, mid, rowLen, colLen) >= k) {
                indexOfK = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return indexOfK;
    }
    
    private int computeCount(int[][] matrix, int x, int n, int m) {
        int count = 0, r = n-1, c = 0;
        
            while(r >= 0 && c < m) {
                if(matrix[r][c] > x) r--;
                else {
                    count += r+1;
                    c++;
                }
            }
        
        return count;
    }
    
    private int computeCount2(int[][] matrix, int x, int n, int m) {
        int count = 0, c = m-1;
        
        for(int r = 0; r < n; ++r) {
            while(c >= 0 && matrix[r][c] > x) {
                --c;
            }
            count += c+1;
        }
        
        return count;
    }
}