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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return constructBT(0, len-1, preorder, 0, len-1, inorder, inorderMap);
    }
    
    public TreeNode constructBT(int preStart, int preEnd, int[] preOrder, int inStart, int inEnd, int[] inOrder, Map<Integer, Integer> map) {
        
        if(inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = map.get(preOrder[preStart]);
        
        int lstCount = index - inStart;
        
        root.left = constructBT(preStart+1, preStart+lstCount, preOrder, inStart, index-1, inOrder, map);
        
         root.right = constructBT(preStart+lstCount+1, preEnd, preOrder, index+1, inEnd, inOrder, map);
        
        return root;
        
    }
}