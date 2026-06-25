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
    public boolean solve(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true ; 
        }
        if(left == null || right == null){
            return false ;
        }
        if(left.val != right.val){
            return false ; 
        }

        
        boolean take1 = solve(left.left , right.right);
        boolean take2 = solve(left.right , right.left);
        return take1 && take2;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true ; 
        if(root.left == null && root.right == null){
            return true ; 
        }
        if(root.left == null || root.right == null){
            return false ;
        }
        return solve(root.left , root.right);
        
    }
}