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

        int pt = 0;
        char[] str = s.toCharArray();

        for(char c:t.toCharArray()){
            if(pt>=str.length){
                return true;
            }
            
            if(str[pt]==c){
                pt++;
            }
        }

        if(pt==str.length){
            return true;
        }else{
            return false;
        }
    }
}