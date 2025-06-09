class Solution {
    public boolean isSubsequence(String s, String t) {
        // Constraints checking
        if(s.length()>100||t.length()>10000){
            return false;
        }
        // Special case
        if(s.length()==0){
            return true;
        }
        
        int pt = 0;     // Points to the current char in s
        char[] str = s.toCharArray();

        for(char c:t.toCharArray()){
            // If matches, increment pointer
            if(str[pt]==c){
                pt++;
            }
            // The pointer is out of bound -> s is fully traversed
            if(pt>=str.length){
                return true;
            }
        }

        return false;
    }
}