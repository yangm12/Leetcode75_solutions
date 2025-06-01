class Solution {
    public String reverseWords(String s) {
        if(s.length()<1 || s.length()>10000){
            return "";
        }

        String[] ws = s.split(" ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(ws));

        // Check for spaces
        words.removeIf(word -> word.equals(""));
        Collections.reverse(words);

        return String.join(" ", words);
    }
}