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
    int[] nums;

    public TreeNode constructTree(int left, int right) {
        if (left > right) return null;

        // always choose right middle node as a root
        int idx = left + ((right - left)>>1);
        if (((left + right) & 1) != 0) idx++;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[idx]);
        root.left = constructTree(left, idx - 1);
        root.right = constructTree(idx + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return constructTree(0, nums.length - 1);
    }
}