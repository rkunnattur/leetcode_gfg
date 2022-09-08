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
        List<Integer> inOrderTraversal = new ArrayList<>();
        
        inOrderTraversal(root, inOrderTraversal);
        return inOrderTraversal;
    }
    
    public void inOrderTraversal(TreeNode root, List<Integer> inOrderTraversal) {
        if(root == null) return;
        
        inOrderTraversal(root.left, inOrderTraversal);
        inOrderTraversal.add(root.val);
        inOrderTraversal(root.right, inOrderTraversal);
    }
}