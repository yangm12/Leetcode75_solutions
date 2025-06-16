class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Constraints checking
        if(asteroids.length<2||asteroids.length>10000) return new int[0]; 

        /* Using stack, beats 64.93% in runtime, 11.87% in memory
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
        */

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i]>0){
                list.add(asteroids[i]);
            }else{
                while(list.size()!=0 && list.get(list.size()-1)>0 && list.get(list.size()-1)<Math.abs(asteroids[i])){
                    list.remove(list.size()-1);
                }
                if(list.size()==0 || list.get(list.size()-1)<0){
                    list.add(asteroids[i]); 
                }
                if(list.get(list.size()-1)==Math.abs(asteroids[i])){
                    list.remove(list.size()-1);
                }
            }
        }

        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}