class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        // Constraints checking
        if(word1.length()<0||word2.length()<0||word1.length()>100||word2.length()>100){
            return res.toString();
        }

        if(!word1.equals(word1.toLowerCase())||!word2.equals(word2.toLowerCase())){
            return res.toString();
        }

        // Find the largest common index 
        int idx = Math.min(word1.length(), word2.length());
        String longer = "a";

        // Get the rest of the longer string
        if (word1.length()>word2.length()){
            longer = new StringBuilder(word1).substring(idx);
        }else{
            longer = new StringBuilder(word2).substring(idx);
        }

        // Convert to char array for easy iteration
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for(int i=0; i<idx; i++){
            res.append(w1[i]);
            res.append(w2[i]);
        }

        // Append the rest of the substring to the result
        res.append(longer);

        // Return result in string
        return res.toString();
    }
}