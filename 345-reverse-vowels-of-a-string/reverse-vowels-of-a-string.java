class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        int end=s.length()-1;
        String vowels ="aeiouAEIOU";

        while (start<end){
            // Move start pointer until it points to a vowel.
            // If the index of the current char is not a vowel, 
            // indexOf will return -1.
            while (start<end && vowels.indexOf(chars[start])==-1){
                start++;
            }

            // Move end pointer until it points to a vowel.
            while(start<end && vowels.indexOf(chars[end])==-1){
                end--;
            }

            // Swap the vowels
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // Move the pointers twd each other
            start++;
            end--;
        }

        return new String(chars);
        
    }
}