class Solution {
    public int longestSubarray(int[] nums) {
        // Constraints checking
        if(nums.length<1||nums.length>100000) return 0;

        // Beats 98.04% runtime, 6.59% memory
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
        

        /* Beats 79.5% runtime, 59.54% memory
        int left = 0, zeros = 0, ans = 0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>1){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, right-left+1-zeros);
        }
        return (ans==nums.length)? ans-1:ans;
        */
    }
}