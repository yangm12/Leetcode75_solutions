class Solution {
    public String reverseVowels(String s) {
        // Constraints checking
        if(s.length()<1 || s.length()>300000){
            return "";
        }

        // Find vowels in s and their corresponding positions
        // Reverse the vowels and insert back to their corresponding positions
        char[] chars = s.toCharArray();
        List<Integer> vowelAsciiCodes = List.of(97, 101, 105, 111, 117,
            65, 69, 73, 79, 85);
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i=0; i<chars.length; i++){
            if(vowelAsciiCodes.contains((int)chars[i])){
                vowels.add(chars[i]);
                pos.add(i);
            }
        }
        Collections.reverse(vowels);
        for(int i=0; i<vowels.size(); i++){
            chars[pos.get(i)] = vowels.get(i);
        }

        System.out.println(chars);



        return new String(chars);
    }
}