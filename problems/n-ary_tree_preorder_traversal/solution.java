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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        traversePreOrder(root, result);
        return result;
    }
    
    private void traversePreOrder(Node root, List<Integer> result) {
        
        if(root == null){
            return;
        }
        
        result.add(root.val);
        
        for (Node child: root.children){
            traversePreOrder(child,result);
        }
    }
}