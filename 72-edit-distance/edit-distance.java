class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=0; i<=n1; i++){
            for(int j=0; j<=n2; j++){
                dp[i][j] = -1;
            }
        }

        return solution(dp, word1, word2, n1, n2);
    }

    private int solution(int[][] dp, String word1, String word2, int i, int j){
        int n1 = word1.length(), n2 = word2.length();

        // Base cases
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1)){
            dp[i][j] = solution(dp, word1, word2, i-1, j-1);
        }else{
            dp[i][j] = 1+Math.min(solution(dp, word1, word2, i-1, j),     // Remove
                        Math.min(solution(dp, word1, word2, i-1, j-1),    // Replace
                                solution(dp, word1, word2, i, j-1)));     // Insert
        }
        return dp[i][j];
    }
}