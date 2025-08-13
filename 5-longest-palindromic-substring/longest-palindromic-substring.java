class Solution {
    /* Approach 1: expand from centre
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;

        String maxStr = s.substring(0, 1);

        for(int i=0; i<s.length()-1; i++){

            // Mirror: curr char
            String odd = expandFromCenter(s, i, i);

            // Mirror: curr and the next char
            String even = expandFromCenter(s, i, i+1);

            if(odd.length() > maxStr.length()){
                maxStr = odd;
            }
            if(even.length() > maxStr.length()){
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right){
        // Boundary control and compare char at left and right position
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        // Left pointer may go beyond to -1
        return s.substring(left+1,right);
    }
    */

    // Approach 2: Manacher Algorithm
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;

        // preprocecss: ^#a#b#b#a#$ (add ^ and $ to the start and the end of the str, use # to separate each char)
        char[] treated = preprocess(s);
        int n = treated.length;
        int[] p = new int[n];   // stores radius for each centre i

        // Current centre and right boundary
        int centre = 0, right = 0;

        for(int i=1; i<n-1; i++){
            int mirror = 2*centre - i;

            if(i<right){
                p[i] = Math.min(right-i, p[mirror]);
            }else{
                p[i] = 0;
            }


            // Expanding around i
            while(treated[i+1+p[i]] == treated[i-1-p[i]]){
                p[i]++;
            }


            if(i+p[i]>right){
                centre = i;
                right = i+p[i];
            }
        }

        int maxLen = 0;
        int cidx=0;
        for(int i=1; i<n-1; i++){
            if(p[i]>maxLen){
                maxLen=p[i];
                cidx = i;
            }
        }

        int start = (cidx-maxLen)/2;
        return s.substring(start, start+maxLen);
    }

    private char[] preprocess(String s) {
        int m = s.length();
        char[] t = new char[2 * m + 3];
        t[0] = '^';
        for (int i = 0; i < m; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[2 * m + 1] = '#';
        t[2 * m + 2] = '$';
        return t;
    }
}