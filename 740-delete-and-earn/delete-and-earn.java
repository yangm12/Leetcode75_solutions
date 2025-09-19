class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 0;
        for(int num: nums){
            n = Math.max(num, n);
        }

        int[] values = new int[n+1];
        for(int num:nums){
            values[num] += num;
        }

        int takei = values[0];
        int skipi = 0;
        for(int i=1;i<=n;i++){
            int temp = takei;
            takei = skipi + values[i];
            skipi = Math.max(skipi, temp);
        }
        return Math.max(takei, skipi);
    }
}