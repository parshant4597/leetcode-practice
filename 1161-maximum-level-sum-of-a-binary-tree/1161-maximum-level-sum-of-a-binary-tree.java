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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE ; 
        Queue<TreeNode > qu = new LinkedList<>();
        qu.offer(root);
        int level  = -1;
        int lev = 0 ; 
        while(!qu.isEmpty()){
            int size  = qu.size();
            int sum = 0 ; 
            lev++;
            while(size--> 0){
                TreeNode top = qu.poll();
                sum += top.val ; 
                if(top.left != null){
                    qu.offer(top.left);
                }
                if(top.right != null){
                    qu.offer(top.right);
                }
            }
            if(sum > max){
                level  = lev ; 
            }
            max = Math.max(sum , max);
        }
        return level ; 


        
    }
}