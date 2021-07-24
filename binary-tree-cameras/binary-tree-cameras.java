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
    int ans = 0;
    Set<TreeNode> covered = new HashSet();
    public int minCameraCover(TreeNode root) {
        if(root == null)
            return ans;
        
        covered.add(null);
        helper(root, null);
        return ans;
    }
    
    public void helper(TreeNode node, TreeNode root){
        if(node != null){
            helper(node.left, node);
            helper(node.right, node);
            
            if((root == null && !covered.contains(node)) || 
              !covered.contains(node.left) || !covered.contains(node.right)){
                ans++;
                covered.add(root);
                covered.add(node);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}