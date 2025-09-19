class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 100001;
        int[] values = new int[n];
        for(int num:nums){
            values[num] += num;
        }
        int takei = values[0];
        int skipi = 0;
        for(int i=1;i<n;i++){
            int temp = takei;
            takei = skipi + values[i];
            skipi = Math.max(skipi, temp);
        }
        return Math.max(takei, skipi);
    }
}