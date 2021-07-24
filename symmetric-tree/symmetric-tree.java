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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode p, TreeNode q){
        if((p == null && q != null) || (p != null && q == null))
            return false;
        if(p == null && q == null)
            return true;
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}