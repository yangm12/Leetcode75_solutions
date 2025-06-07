class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Constraints checking
        if(nums.length<1||nums.length>500000){
            return false;
        }

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int n:nums){
            if(n<=first){
                first=n;
            }else if(n<=second){
                second=n;
            }else{
                return true;
            }
        }

        return false;

    }
}