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
class Solution {
    private boolean isvalid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isvalid(node.left, min, node.val) && isvalid(node.right, node.val, max);
    }
    public boolean isbst(TreeNode root) {
        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    int max = 0;
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return  new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        // bst hai toh 2 choices 
        // take or notake ; 
        // bst nhi hai 1 choices 
        // 0 and notake ;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right); 
        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            int sum = left[3]+ right[3] + root.val ; 
            max = Math.max(sum , max);
            return new int[]{1 , Math.min(root.val , left[1]) , Math.max(root.val , right[2]) , sum}; 
        }
        return new int[]{0 , 0 ,0 ,0 };

    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }
}
// class Solution {
//     private int maxSum = 0;

//     public int maxSumBST(TreeNode root) {
//         postOrder(root);
//         return maxSum;
//     }

//     private int[] postOrder(TreeNode node) {
//         if (node == null) {
//             return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
//         }
//         int[] left = postOrder(node.left);
//         int[] right = postOrder(node.right);
//         if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
//             int currentSum = node.val + left[3] + right[3];
//             maxSum = Math.max(maxSum, currentSum);
//             int minVal = Math.min(node.val, left[1]);
//             int maxVal = Math.max(node.val, right[2]);

//             return new int[]{1, minVal, maxVal, currentSum};
//         }
//         return new int[]{0, 0, 0, 0};
//     }
// }