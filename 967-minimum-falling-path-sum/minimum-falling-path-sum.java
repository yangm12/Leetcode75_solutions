class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;    // number of rows
        int[][] dp = new int[n][n];
        if(n == 1) return matrix[0][0];

        for(int[] r:dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        int currMin = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            currMin = Math.min(currMin, minFallingPathSum(matrix, 0, i, dp, n));
        }
        return currMin;
    }

    private int minFallingPathSum(int[][] matrix, int row, int col, int[][] dp, int n){
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];

        // Last row, cannot get falling values
        if(row == n-1){
            return dp[row][col] = matrix[row][col];
        }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if(col>0){
            left = minFallingPathSum(matrix, row+1, col-1, dp, n);
        }

        int straight = minFallingPathSum(matrix, row+1, col, dp, n);

        if(col<n-1){
            right = minFallingPathSum(matrix, row+1, col+1, dp, n);
        }

        dp[row][col] = Math.min(left, Math.min(straight, right)) + matrix[row][col];

        return dp[row][col];
    }
}