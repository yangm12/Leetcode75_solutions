class Solution {
    public int maxArea(int[] height) {
        // Constraints checking
        if(height.length<2||height.length>100000){
            return 0;
        }

        if(height.length==2){
            return Math.min(height[0],height[1])*Math.min(height[0],height[1]);
        }

        int right = height.length-1;
        int area = 0;
        for(int left=0; left<right;){
            int temp = (right-left)*(Math.min(height[left], height[right]));
            if(area<temp){
                area = temp;
                // left++;
                System.out.println("left: "+area);
            }else{
                // right--;
                System.out.println("right: "+area);
            }
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }

            
        }
        return area;
    }
}