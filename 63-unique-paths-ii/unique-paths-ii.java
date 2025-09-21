class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;        // number of rows
        int n = obstacleGrid[0].length;     // number of columns
        int[] dp = new int[n];
        dp[0] = 1;                          // 1 way to reach top-left

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(obstacleGrid[r][c] == 1){
                    dp[c] = 0;
                }else{
                    if(c>0){
                        dp[c]+=dp[c-1];
                    }
                }
            }
        }
        return dp[n - 1];
    }
}