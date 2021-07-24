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
    public int longestZigZag(TreeNode root) {
        return zig(root, 0)-1;
    }
    
    public int zig(TreeNode node, int run){
        if(node == null) return run;
        return Math.max(zig(node.left, 1), zag(node.right, 1+run));
    }
    
    public int zag(TreeNode node, int run){
        if(node == null) return run;
        return Math.max(zig(node.left, 1+run), zag(node.right, 1));
    }
}