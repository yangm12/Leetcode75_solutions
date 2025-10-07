class Solution {
    public String reverseWords(String s) {
        if(s.length()<=1) return s;

        String[] list = s.split(" ");

        for(int i=0; i<list.length; i++){
            StringBuilder sb = new StringBuilder(list[i]);
            list[i] = sb.reverse().toString();
        }
        
        return String.join(" ", list);
    }
}