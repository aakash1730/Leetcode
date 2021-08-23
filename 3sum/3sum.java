class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1])
                twoSum(ans, i, nums);
        }
        return ans;
    }
    
    public void twoSum(List<List<Integer>> ans, int index, int[] nums){
        int lo = index+1;
        int hi = nums.length-1;
        
        while(lo < hi){
            int sum = nums[index] + nums[lo] + nums[hi];
            if(sum < 0){
                lo++;
            }
            else if(sum > 0){
                hi--;
            }
            else{
                ans.add(Arrays.asList(nums[index], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo-1])
                    lo++;
            }
        }
    }
}