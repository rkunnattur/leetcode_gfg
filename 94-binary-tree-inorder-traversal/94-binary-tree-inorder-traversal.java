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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        return inorderTraversalR(root);
    }
    
    public List<Integer> inorderTraversalR(TreeNode root) {
        List<Integer> inorderList = new ArrayList<Integer>();
        inorderTraversalR(root, inorderList);
        return inorderList;
    }
    
    public void inorderTraversalR(TreeNode root, List<Integer> inorderList) {
        if(root == null) return;
        
        inorderTraversalR(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversalR(root.right, inorderList);
    }
    
    
    
    
}