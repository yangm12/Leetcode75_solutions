class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Constraints checking
        if(k<1||k>100000||nums.length<1||nums.length>100000){
            return 0.0;
        }

        int max_sum = -Integer.MAX_VALUE;
        if(nums.length==k){
            max_sum = Arrays.stream(nums).sum();
            return (double)max_sum/k;
        }

        for(int i=0; i<nums.length-k+1; i++){
            int curr_sum = nums[i];
            for(int j=1; j<k;j++){
                curr_sum+=nums[i+j];
            }
            max_sum = Math.max(max_sum, curr_sum);
        }
        return (double)max_sum/k;
    }
}