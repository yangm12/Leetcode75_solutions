class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        int n0 = 0, n1 = 1, n2 = 1;
        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = n0+n1+n2;
            int temp2 = n2;
            int temp1 = n1;
            n2 = curr;
            n1 = temp2;
            n0 = temp1;
        }

        return curr;
    }
}