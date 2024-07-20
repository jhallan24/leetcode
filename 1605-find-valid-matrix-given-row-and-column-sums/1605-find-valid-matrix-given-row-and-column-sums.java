class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minVal = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = minVal;
                rowSum[i] -= minVal;
                colSum[j] -= minVal;
            }
        }

        return matrix;
    
    }
}