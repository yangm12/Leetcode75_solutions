class Solution {
    public String removeStars(String s) {
        // Constraints checking
        if(s.length()<1||s.length()>100000) return "";

        /* Beats 61.98% runtime, 52.95% memory
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='*'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c:stack){
            sb.append(c);
        }

        return sb.toString();
        */

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}