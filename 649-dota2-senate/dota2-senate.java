class Solution {
    public String predictPartyVictory(String senate) {
        // Constraints checking
        if(senate.length()<1||senate.length()>10000) return "";

        char[] chars = senate.toCharArray();
        Queue<Integer> rs = new LinkedList<>();
        Queue<Integer> ds = new LinkedList<>();
        int n = senate.length();
        for(int i=0; i<n; i++){
            if(chars[i]=='R'){
                rs.offer(i);
            }else if(chars[i]=='D'){
                ds.offer(i);
            }else{
                return "";
            }
            
        }

        while(!rs.isEmpty() && !ds.isEmpty()){
            // int r = rs.poll();
            // int d = ds.poll();
            if(rs.poll()<ds.poll()){
                rs.offer(n);
            }else{
                ds.offer(n);
            }
            n++;
        }

        return (rs.isEmpty()) ? ("Dire") : ("Radiant");
    }
}