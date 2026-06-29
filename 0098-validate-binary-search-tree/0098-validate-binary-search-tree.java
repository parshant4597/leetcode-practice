// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     ArrayList<Integer> arr ; 
//     public void solve(TreeNode root){
//          if(root == null)return ;
//          solve(root.left);
//          arr.add(root.val);
//          solve(root.right);
//     }
//     public boolean isValidBST(TreeNode root) {
//         arr = new ArrayList<>();
//          solve(root);
//          for(int i = 1 ; i < arr.size()  ; i++){
//             if(arr.get(i) <= arr.get(i-1))return false; 
//          }
//          return true ; 
//     }
// }
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, long val1, long val2){

        if(root == null){
            return true;
        }
        if(root.val <= val1 || root.val >= val2){
            return false;
        }
        
        return helper(root.left, val1, root.val) && helper(root.right, root.val, val2);
    }

    
}