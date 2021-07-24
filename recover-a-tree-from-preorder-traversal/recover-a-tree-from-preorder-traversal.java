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
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length() == 0)
            return null;
        
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        return helper(traversal, sb);
    }
    
    public TreeNode helper(String traversal, StringBuilder sb){
        String searchString = sb.toString();
        int sbLen = sb.length();
        sb.append("-");
        int firstIndex = traversal.indexOf(searchString);
        int lastIndex = findIndex(traversal.substring(firstIndex+1, traversal.length()), sbLen);
        lastIndex += firstIndex+1;
        // System.out.println(searchString + "   #  " + traversal + "   #  " + firstIndex + " " + lastIndex);
        TreeNode node = null, leftNode = null, rightNode = null;
        if(firstIndex != -1){
            if(firstIndex == lastIndex)
                leftNode = helper(traversal.substring(firstIndex+sbLen, traversal.length()), sb);
            else{
                leftNode = helper(traversal.substring(firstIndex+sbLen, lastIndex), sb);
                rightNode = helper(traversal.substring(lastIndex+sbLen, traversal.length()), sb);
            }    
        }
        
        node = new TreeNode();
            
        sb.deleteCharAt(sb.length() - 1);
        // System.out.println("here" + " " + firstIndex + " " + traversal);
        if(firstIndex != -1)
            node.val = Integer.parseInt(traversal.substring(0, firstIndex));
        else
            node.val = Integer.parseInt(traversal);
        
        node.left = leftNode;
        node.right = rightNode;
        
        return node;
    }
    
    public int findIndex(String traversal, int length){
        int count = 0, index = -1;
        
        for(int i = 0; i < traversal.length(); i++){
            if(traversal.charAt(i) == '-'){
                if(count == 0)
                    index = i;
                count++;
            }
            else{
                if(count == length)
                    return index;
                
                count = 0;
                index = -1;
            }
        }
        
        return -1;
    }
    
}