class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<Boolean>();

        // Constraint checking
        if (candies.length>100||candies.length<2||extraCandies<1||extraCandies>50){
            return Collections.emptyList();
        }

        int max = findMax(candies);
        if(extraCandies>max){
            res = Collections.nCopies(candies.length, true);
            return Collections.emptyList();
        }

        for (int i=0; i<candies.length; i++){
            // Constraint checking
            if (candies[i]<1||candies[i]>100){
                return Collections.emptyList();
            }

            if (candies[i]+extraCandies>=max){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;
    }

    private int findMax(int[] nums){
        int max = 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}