class Solution {
    public String gcdOfStrings(String str1, String str2) {      
        // Constraint checking
        if(str1.length()<1||str1.length()>1000||str2.length()<1||str2.length()>1000){
            return "";
        }
        if(!str1.equals(str1.toUpperCase())||!str2.equals(str2.toUpperCase())){
            return "";
        }

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }  

        int lenGCD = gcd(str1.length(), str2.length());
        return str1.substring(0, lenGCD);
    }

    private int gcd(int len1, int len2){
        while (len2!=0){
            // Modulus division (return remainder)
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }
        return len1;
    }
}