class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 0, end = 10000007;
        int mid = 0, len = dist.length, ans = -1;
        double time = 0;
        while(start <= end){
            mid = (start + end)/2;
            time = 0;
            for(int i = 0; i < len-1; i++){
                time += Math.ceil((double)dist[i]/mid);
            }
            
            time += (double)dist[len-1]/mid;
            
            if(time > hour){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid -1;                
            }
        }
        return ans;
    }
}