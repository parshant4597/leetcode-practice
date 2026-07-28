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
    
//     public int rob(TreeNode root) {

//         return solve(root, new HashMap<>());
//     }

//     private int solve(TreeNode root, Map<TreeNode, Integer> map) {
//         if (root == null)
//             return 0;
//         if (map.containsKey(root))
//             return map.get(root);

//         int val = 0;

//         if (root.left != null) {
//             val += solve(root.left.left, map) + solve(root.left.right, map);
//         }

//         if (root.right != null) {
//             val += solve(root.right.left, map) + solve(root.right.right, map);
//         }

//         val = Math.max(val + root.val, solve(root.left, map) + solve(root.right, map));
//         map.put(root, val);

//         return val;
//     }
// }

class Solution {
    public int rob(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0}; 
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        int[] dp = new int[2]; 
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); 
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}