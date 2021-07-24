class Solution {
    public int numTrees(int n) {
        double r = 2*n;
        double y = n;
        double ans = 1D;
        while(r > n){
            ans = ans*(r/y);
            r--;
            y--;
        }        
        return (int)(Math.ceil(ans)/(n+1));
            
    }
}