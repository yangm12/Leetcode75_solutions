class Solution {
    public int compress(char[] chars) {
        // Constraints checking
        if(chars.length<1||chars.length>2000){
            return 0;
        }
        // Special case
        if(chars.length==1){
            return 1;
        }

        int index = 0;
        for (int i = 0; i < chars.length; ) {
            char curr_char = chars[i];
            int ctr = 0;

            // Count how many times ch repeats
            while (i < chars.length && chars[i] == curr_char) {
                i++;
                ctr++;
            }

            // Write character
            chars[index++] = curr_char;
            System.out.println(new String(chars));

            // Write count if more than 1
            if (ctr > 1) {
                for (char c : String.valueOf(ctr).toCharArray()) {
                    chars[index++] = c;
                }
            }
            System.out.println("after: "+new String(chars));
        }
        System.out.println(index);
        return index;
    
    }
}