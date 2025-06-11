class Solution {
    public int maxVowels(String s, int k) {
        // Constraints checking
        if(s.length()<1||s.length()>100000||k<1||k>s.length()){
            return -1;
        }

        int curr = 0;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        char[] str = s.toCharArray();

        // First window
        for(int i=0; i<k; i++){
            if(vowels.contains(str[i])){
                curr++;
            }
            if(curr==k){
                return k;
            }
        }

        int max = curr;
        // Following windows
        for(int i=k; i<str.length; i++){
            if(vowels.contains(str[i])){
                curr++;
            }
            if(vowels.contains(str[i-k])){
                curr--;
            }
            if(curr==k){
                return k;
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}