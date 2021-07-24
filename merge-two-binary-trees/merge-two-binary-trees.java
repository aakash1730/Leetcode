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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        
        if(root2 == null)
            return root1;
        
        helper(root1, root2);
        return root1;
    }
    
    public void helper(TreeNode node1, TreeNode node2){
        node1.val += node2.val;
        
        if(node1.left != null && node2.left != null)
            helper(node1.left, node2.left);
        else{
            if(node1.left == null && node2.left != null){
                node1.left = node2.left;
            }
        }
        
        if(node1.right != null && node2.right != null)
            helper(node1.right, node2.right);
        else{
            if(node1.right == null && node2.right != null){
                node1.right = node2.right;
            }
        }
    }
}