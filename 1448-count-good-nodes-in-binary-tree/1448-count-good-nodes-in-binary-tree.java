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
    
    public int goodNodes(TreeNode root) {
        
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    public int countGoodNodes(TreeNode node, int maxValSoFar) {
        if(node == null) return 0;
        
        int goodNodes = ((node.val >= maxValSoFar)  ?  1 : 0);
        
        maxValSoFar = Math.max(maxValSoFar, node.val);
        goodNodes += countGoodNodes(node.left, maxValSoFar);
        goodNodes += countGoodNodes(node.right, maxValSoFar);  
        
        return goodNodes;
    }
}