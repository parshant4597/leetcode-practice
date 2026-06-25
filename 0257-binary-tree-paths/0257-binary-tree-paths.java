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
    List<String> list ;
    int prev = -1;
    public void solve(TreeNode root , String res){
        if(root.left == null && root.right == null){ 
            res += root.val; 
                list.add(res);
            
            return ; 
        }  
        res += root.val+ "->";     
        if(root.left != null){     
            solve(root.left , res);
        }
        if(root.right != null){ 
            solve(root.right , res);

        }
          
    }
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if(root == null){
            return list ; 
        }
        solve(root , "");
        return list ;
    }
}