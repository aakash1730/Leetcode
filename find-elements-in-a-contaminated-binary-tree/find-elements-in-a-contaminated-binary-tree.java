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
class FindElements {
    TreeNode root;
    Set<Integer> valSet;
    public FindElements(TreeNode root) {
        valSet = new HashSet();
        help(root, 0, valSet);
        this.root = root;
    }
    
    public boolean find(int target) {
        return valSet.contains(target);
    }
    
    public void help(TreeNode node, int val, Set<Integer> set){
        if(node == null)
            return;
        
        node.val = val;
        set.add(val);
        help(node.left, val*2 + 1, set);
        help(node.right, val*2 + 2, set);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */