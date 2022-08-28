class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> dict = new HashMap<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dict.putIfAbsent(r - c, new PriorityQueue<>());
                dict.get(r - c).add(mat[r][c]);
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                mat[r][c] = dict.get(r - c).poll();
            }
        }
        return mat;
    }
}