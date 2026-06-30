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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lis = new ArrayList<>();
        Queue<TreeNode > qu = new LinkedList<>();
        qu.offer(root);
        if(root == null)return lis;
         
        while(!qu.isEmpty()){
            int size  = qu.size();
          
            int max = Integer.MIN_VALUE ; 
            while(size--> 0){
                TreeNode top = qu.poll();
                if(top != null){
                    max  = Math.max(max , top.val); 

                }
                if(top.left != null){
                    qu.offer(top.left);
                }
                if(top.right != null){
                    qu.offer(top.right);
                }
            }
            lis.add(max );
        }
        return lis ; 


        
    }
}