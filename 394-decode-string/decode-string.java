class Solution {
    public String decodeString(String s) {
        // Constraints checking
        if(s.length()<1||s.length()>30) return "";


        Stack<Integer> ctrs = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n=0;

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                n=n*10+(c-'0');
            }else if(c=='['){
                // Push the counter 
                ctrs.push(n);
                // Initialise the current counter
                n=0;
                // Push current string 
                strs.push(sb);
                // Initialise the current string
                sb = new StringBuilder();

            // When the current string ends
            }else if(c==']'){
                // Get the counter of the ended string
                int k=ctrs.pop();
                StringBuilder temp = sb;
                // Get the previous strings
                sb=strs.pop();
                // Populate the current string
                while(k-->0) sb.append(temp);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}