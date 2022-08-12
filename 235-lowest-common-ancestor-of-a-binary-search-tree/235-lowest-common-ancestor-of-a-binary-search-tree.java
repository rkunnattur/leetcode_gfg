/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
         return ((root.val - p.val) * (root.val - q.val) < 1) ? root : (p.val < root.val) ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
     
     }
    
    
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        /* compute root - node values n get product of diff, iff diff -ve return root
            else go lefft or right based on node.val < root.val > left : right
        */
        while ((root.val - p.val) * (root.val - q.val) > 0) 
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
    
    
}