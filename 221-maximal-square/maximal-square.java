class Solution {
    int row;
    int col;
    public int maximalSquare(char[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;

        int[][] dp = new int[row][col];
        int size = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == '1'){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                        System.out.println(dp[i][j]);
                        System.out.println("i: "+i);
                        System.out.println("j: "+j);
                    }
                    size = Math.max(size, dp[i][j]);
                }
            }
        }

        return size*size;
    }

}