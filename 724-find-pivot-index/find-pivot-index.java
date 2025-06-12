class Solution {
    public int pivotIndex(int[] nums) {
        // Constraints checking
        if(nums.length<1||nums.length>10000) return -1;

        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            temp+=nums[i];
            sumLeft[i]=temp;
        }
        temp = 0;
        for(int i=nums.length-1; i>=0; i--){
            temp+=nums[i];
            sumRight[i]=temp;
        }
        for(int i=0; i<nums.length; i++){
            if(sumLeft[i]==sumRight[i]) return i;
        }
        return -1;
    }
}