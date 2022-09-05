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
   public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
       
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
       
        Node curr = null;
        List<List<Integer>> listOfLevels = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        while (!q.isEmpty()) {
            curr = q.remove();
            if (curr == null) {
                // Collections.reverse(ar);
                listOfLevels.add(levelList);
                // ar.clear();
                levelList = new ArrayList<>();
                if (!q.isEmpty()) q.add(null);
                else break;
            } else {
                levelList.add(curr.val);
                for(int i = 0; i < curr.children.size(); i++) {
                    q.add(curr.children.get(i));
                }
            }
        }
       
        return listOfLevels;
    }
}