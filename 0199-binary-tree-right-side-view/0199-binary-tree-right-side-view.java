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
class Pair{
    TreeNode node ; 
    int curr ; 
    public Pair(TreeNode node , int curr){
        this.node = node ; 
        this.curr = curr ; 
    }
    public int get(){
        return curr ; 
    }

}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Stack<Pair> qu = new Stack<>();
        qu.push(new Pair(root , 1 ));
        List<Integer> ans = new ArrayList<>();
        int lev = 0 ; 
        while(!qu.isEmpty()){
            Pair top = qu.pop();
            int currlevel = top.get();
            TreeNode topnode = top.node ;
            if(topnode != null && lev <= top.get()){
                ans.add(top.node.val);
            }      
            if(topnode != null && topnode.left != null){
                qu.push(new Pair(topnode.left  , currlevel +1));
            }
            if(topnode != null && topnode.right != null){
                qu.push(new Pair(topnode.right ,currlevel+1 ));
            }
             
            lev = Math.max(lev , currlevel+1);
        }
        return ans ; 
        
    }
}