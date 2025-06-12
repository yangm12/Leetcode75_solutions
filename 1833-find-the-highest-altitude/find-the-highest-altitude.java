class Solution {
    public int largestAltitude(int[] gain) {
        // Constraints checking
        if(gain.length<1||gain.length>100) return 0;

        int altitude = 0;
        int max = 0;
        for(int i=0; i<gain.length; i++){
            altitude+=gain[i];
            max = Math.max(max, altitude);
        }
        return max;
    }
}