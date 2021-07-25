class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for(int i : nums){
            if(i < min)
                min = i;
        }
        
        int count = 0;
        
        for(int i : nums)
            count += i - min;
        
        return count;
    }
}