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
    public boolean solve(TreeNode root , TreeNode sub){
        if(root == null && sub == null)return true ; 
        if(root == null ||  sub == null)return false ; 
         
        if(root.val != sub.val)return false ;
        return solve(root.left , sub.left) && solve(root.right , sub.right);
    }
    public boolean iterate(TreeNode root , TreeNode sub){
        if(root == null)return false ; 
        boolean ans = false ;
        if(root.val == sub.val){
            ans =  solve(root , sub);
        }     
        boolean left = iterate(root.left , sub);
        boolean right = iterate(root.right , sub);
         
        return ans || left || right ; 
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return iterate(root , subRoot);
        
    }
}