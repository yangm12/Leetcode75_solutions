class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Constraints checking
        if(flowerbed.length<1||flowerbed.length>20000||n<0||n>flowerbed.length)
        {
            return false;
        }
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i]!=0&&flowerbed[i]!=1){
                return false;
            }
        }

        System.out.println("in");
        for(int i=0; i<flowerbed.length; i++){
            // Check whether it's at the leftmost position or the left postition is empty
            boolean left=i==0||flowerbed[i-1]==0;
            // Check whether it's at the rightmost position or the right postition is empty
            System.out.println(left);
            boolean right=i==flowerbed.length-1||flowerbed[i+1]==0;
            System.out.println(right);

            if(left && right && flowerbed[i]==0){
                flowerbed[i]=1;
                n--;
            }
        }

        return n<=0;

    }
}