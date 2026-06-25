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
    public void solve(TreeNode root , Stack<Integer> st){
        if(root == null){
            return ; 
        }
        solve(root.right , st);
        solve(root.left, st);
        st.push(root.val);
    }
    public void flatten(TreeNode root) {
        if(root == null ){
            return ; 
        }
        Stack<Integer> st = new Stack<>();
        solve(root , st);
        
        st.pop();
        TreeNode temp = root ; 
        while(!st.isEmpty()){
            temp.left = null ; 
            temp.right = new TreeNode(st.pop());
           temp = temp.right;
        }
        temp.left = null;
        temp.right = null;
         

        

        
    }
}