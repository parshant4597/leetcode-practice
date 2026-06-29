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
    public boolean isBalanced(TreeNode root) {
        return solve(root);
    }

    public boolean solve(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) >1 ) {
            return false ;
        }
         
        boolean leftsub = solve(root.left);
        boolean rightsub = solve(root.right); 
        
        return leftsub && rightsub;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}