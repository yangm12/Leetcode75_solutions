class Solution {
    public int longestSubarray(int[] nums) {
        // Constraints checking
        if(nums.length<1||nums.length>100000) return 0;

        int left = 0;
        int k = 1;
        for(int right=0; right<nums.length; right++){
            if(nums[right]==0){
                k--;
            }
            if(k<0){
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
        }
        return nums.length-left-1;
    }
}