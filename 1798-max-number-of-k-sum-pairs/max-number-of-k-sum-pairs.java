class Solution {
    public int maxOperations(int[] nums, int k) {
        // Constraints checking
        if(nums.length<1||nums.length>100000||k<1||k>1000000000){
            return 0;
        }

        Arrays.sort(nums);
        int right = nums.length-1;
        int ctr = 0;
        for(int left = 0; left<right;){
            if(nums[left]+nums[right]==k){
                left++;
                right--;
                ctr++;
            }else if(nums[left]+nums[right]<k){
                left++;
            }else{
                right--;
            }
        }

        return ctr;
    }
}