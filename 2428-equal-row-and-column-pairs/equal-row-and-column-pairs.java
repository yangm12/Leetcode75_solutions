class Solution {
    public int equalPairs(int[][] grid) {
        // Constraints checking
        if(grid.length<1||grid.length>200) return -1;

        // Map<String, Integer> map = new HashMap<>();
        // for(int[] row:grid){
        //     map.merge(Arrays.toString(row), 1, Integer::sum);
        // }

        // int ctr=0;
        // for(int c=0; c<grid.length; c++){
        //     int[] col = new int[grid.length];
        //     for(int r=0; r<grid.length; r++){
        //         col[r] = grid[r][c];
        //     }
        //     ctr += map.getOrDefault(Arrays.toString(col), 0);
        // }
        // return ctr;

        int n = grid.length;
        Map<List<Integer>, Integer> rowCounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowCounts.put(row, rowCounts.getOrDefault(row, 0) + 1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(grid[j][i]);
            }
            count += rowCounts.getOrDefault(col, 0);
        }

        return count;
    }
}