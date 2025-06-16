class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Constraints checking
        if(asteroids.length<2||asteroids.length>10000) return new int[0]; 

        Stack<Integer> as = new Stack<>();
        for(int a:asteroids){
            if(a>0){
                as.push(a);
            }else{
                while(!as.isEmpty() && as.peek()>0 && as.peek()<-a) as.pop();
                if(as.isEmpty() || as.peek()<0) as.push(a);
                if(as.peek()==-a) as.pop();
            }
        }

        int[] res = new int [as.size()];
        int i = as.size()-1;

        while(!as.isEmpty()){
            res[i--]=as.pop();
        }
        return res;
    }
}