/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 1;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        // System.out.println(start + " " + end);
        // count++;
        // if(count >= 20) return null;
        if(start > end){
            // System.out.println("-----------------");
            return null;
        }
            
        
        int[] indexValue = findMax(nums, start, end);
        
        int index = indexValue[0], value = indexValue[1];
        // System.out.println(index + " " + value);
        // System.out.println("-----------------");
        TreeNode node = new TreeNode(value);
        
        node.left = helper(nums, start, index-1);
        node.right = helper(nums, index+1, end);
        
        return node;
    }
    
    public int[] findMax(int[] nums, int start, int end){
        int index = -1, max = -1;
        for(int i = start; i <= end; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return new int[]{index, max};
    }
    
}