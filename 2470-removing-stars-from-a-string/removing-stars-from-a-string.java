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

        /* Beats 70.15% runtime, 63.85% memory
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        */

        char[] arr= s.toCharArray();
        int i=0;
        for(char ch:arr)
        {
            if(ch=='*') i--;
            else arr[i++]=ch;
        }
        return new String(arr,0,i);
    }
}