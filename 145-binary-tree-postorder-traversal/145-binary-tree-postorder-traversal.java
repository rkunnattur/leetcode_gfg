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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        
        postorderTraversal(root, postorderList);
        return postorderList;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> postorderList) {
        if(root == null) return;
        
        postorderTraversal(root.left, postorderList);
        postorderTraversal(root.right, postorderList);
        postorderList.add(root.val);
    }
}