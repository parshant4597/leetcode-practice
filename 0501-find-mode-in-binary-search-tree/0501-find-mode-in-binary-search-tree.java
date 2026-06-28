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
    public void solve(TreeNode root , HashMap<Integer, Integer> map){
        if(root == null){
            return ; 
        }
        map.put(root.val , map.getOrDefault(root.val , 0)+1);
        solve(root.left , map);
        solve(root.right , map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root  , map);
        int num = -1;
        int max = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){ 

            int val  = entry.getValue();
            if(val > max){
                max = val ; 
                num = entry.getKey();
            }


        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){ 
            int val  = entry.getValue();
            if(val == max){
                ans.add(entry.getKey());
            }
        }
        int[] ansarr = new int[ans.size()];
        for(int i = 0 ;  i < ans.size()  ; i++){
            ansarr[i] = ans.get(i);
        }
        return ansarr ; 
        
    }
}