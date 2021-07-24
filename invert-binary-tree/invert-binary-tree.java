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
    
    public void treeInvert(TreeNode node){
        if(node == null)
            return;
        
        TreeNode tempLeftTree = node.left;
        node.left = node.right;
        node.right = tempLeftTree;
        
        treeInvert(node.left);
        treeInvert(node.right);
        
    }
    
    public TreeNode invertTree(TreeNode root) {
        treeInvert(root);
        
        return root;
    }
}