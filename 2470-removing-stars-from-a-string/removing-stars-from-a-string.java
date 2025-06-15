class Solution {
    public String removeStars(String s) {
        // Constraints checking
        if(s.length()<1||s.length()>100000) return "";

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
    }
}