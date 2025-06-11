class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Constraints checking
        if(k<1||k>100000||nums.length<1||nums.length>100000){
            return 0.0;
        }

        int sum = 0;
        // Find the total sum of the current window of size k
        for(int i = 0; i<k; i++){
            sum += nums[i];
        }

        int maxSum = sum;

        // Find the total sum of the next window of size k, 
        // and compare them. 
        for(int i = k; i<nums.length; i++){
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }
}