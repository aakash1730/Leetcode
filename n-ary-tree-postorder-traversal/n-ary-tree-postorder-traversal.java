/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> postorder(Node root) {
        helper(root);
        return ans;
    }
    
    public void helper(Node node){
        if(node == null)
            return;
        
        for(Node nod : node.children)
            helper(nod);
        
        ans.add(node.val);
    }
}