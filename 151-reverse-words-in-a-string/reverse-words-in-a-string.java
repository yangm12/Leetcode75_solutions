class Solution {
    public String reverseWords(String s) {
        // Using 2 pointers to solve the problem
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;

        // 2 pointer reversing
        while (left<right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuilder res = new StringBuilder();
        for(String word:words){
            if(!word.isEmpty()){
                // Manually adding white spaces between words
                if(res.length()>0){
                    res.append(" ");
                }
                res.append(word);
            }
        }

        return res.toString();

    }
}