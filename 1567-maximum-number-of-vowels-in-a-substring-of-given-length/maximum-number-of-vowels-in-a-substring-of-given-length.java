class Solution {
    public int maxVowels(String s, int k) {
        // Constraints checking
        if(s.length()<1||s.length()>100000||k<1||k>s.length()){
            return -1;
        }

        int curr = 0;
        char c = '1';
        char ch = '1';

        // First window
        for(int i=0; i<k; i++){
            c=s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') curr++;
            if(curr==k){
                return k;
            }
        }

        int max = curr;
        // Following windows
        for(int i=k; i<s.length(); i++){
            c=s.charAt(i);
            ch=s.charAt(i-k);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') curr++;
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') curr--;
            if(curr==k){
                return k;
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}