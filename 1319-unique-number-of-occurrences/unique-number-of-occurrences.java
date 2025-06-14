class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Constraints checking
        if(arr.length<1||arr.length>1000) return false;

        Map<Integer, Integer> freq =  new HashMap<>();
        for (int n:arr){
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }

        Set<Integer> set = new HashSet<>();
        for (int n:freq.values()){
            set.add(n);
        }

        return freq.size()==set.size();
    }
}