class Solution {
    public void moveZeroes(int[] nums) {
        // Constraints checking + Special case
        if(nums.length<=1||nums.length>10000){
            return;
        }

        int left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]!=0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}