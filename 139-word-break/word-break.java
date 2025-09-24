class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;                       // base case

        for(int i = 1; i<=s.length(); i++){
            for(String w : wordDict){
                int start = i-w.length();
                if(start>=0 && dp[start] && s.substring(start, i).equals(w)){
                    dp[i] = true;
                    break;
                }
            }
        }

        // System.out.println(Arrays.toString(dp));

        return dp[s.length()];
    }
}