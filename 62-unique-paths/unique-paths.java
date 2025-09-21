class Solution {
    public int uniquePaths(int m, int n) {
        int[] aboveRow = new int[n];
        int curr = 0;
        Arrays.fill(aboveRow, 1);

        for(int i=1; i<m; i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    curr = 1;
                    continue;
                }
                // int temp = curr;
                curr = curr + aboveRow[j];
                aboveRow[j] = curr;
            }
        }

        return aboveRow[n-1];
    }
}