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
    public TreeNode pruneTree(TreeNode root) {
        int value = helper(root);
        
        if(value == 0)
            return null;
        
        return root;
    }
    
    public int helper(TreeNode node){
        if(node == null)
            return 0;
        
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        
        if(leftSum == 0)
            node.left = null;
        
        if(rightSum == 0)
            node.right = null;
        
        return node.val + leftSum + rightSum;
    }
}