class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;     // number of columns
        int m = grid.length;        // number of rows
        int[] aboveRowSum = new int[n];
        aboveRowSum[0] = grid[0][0];

        for(int i=1; i<n; i++){
            aboveRowSum[i] = aboveRowSum[i-1] + grid[0][i];
        }

        for(int i=1; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(j==0){
                    aboveRowSum[j] = aboveRowSum[j] + grid[i][j];
                    continue;
                }
                aboveRowSum[j] = Math.min(aboveRowSum[j], aboveRowSum[j-1]) + grid[i][j];
            }
        }
        return aboveRowSum[n-1];
    }
}