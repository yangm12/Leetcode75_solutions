class Solution {
    static Map<Character, Integer> dict = new HashMap<>();

    /* Approach 1: O(m*n)
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        return solution(dp, s1, s2, s1.length(), s2.length());
    }
    

    private int solution(int[][] dp, String s1, String s2, int i, int j){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==0){
            return solution(dp, s1, s2, 0, j-1) + s2.charAt(j-1);
        }
        if(j==0){
            return solution(dp, s1, s2, i-1, 0) + s1.charAt(i-1);
        }
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = solution(dp, s1, s2, i-1, j-1);
        }else{
            dp[i][j] = Math.min(solution(dp, s1, s2, i-1, j)+s1.charAt(i-1),
                                solution(dp, s1, s2, i, j-1)+s2.charAt(j-1)
            );
        }
        return dp[i][j];
    }
    */

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n+1];
        
        // Cumulative sum to remove characters from s2
        for(int j=1; j<=n; j++){
            dp[j] = dp[j-1]+s2.charAt(j-1);
        }

        for(int i=1; i<=m; i++){
            int prev = dp[0];
            dp[0] += s1.charAt(i-1);

            System.out.println(Arrays.toString(dp));

            for(int j=1; j<=n; j++){
                int temp = dp[j];

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = prev;
                }else{
                    dp[j] = Math.min(dp[j]+s1.charAt(i-1), dp[j-1]+s2.charAt(j-1));
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}