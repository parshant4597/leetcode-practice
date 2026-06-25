class Solution {
    List<String> ansList;

    public void solve(TreeNode root, StringBuilder sb) {
        int num = root.val;
        char ch = (char) (num + 'a');
        
        // Append the current character to the path
        sb.append(ch);

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            // Reverse the path to get the string from leaf to root
            String rev = new StringBuilder(sb).reverse().toString();
            ansList.add(rev);
            
            // Backtrack: remove the character before returning
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (root.left != null) {
            solve(root.left, sb);
        }
        if (root.right != null) {
            solve(root.right, sb);
        }

        // Backtrack: remove the character when popping out of this node
        sb.deleteCharAt(sb.length() - 1);
    }

    public String smallestFromLeaf(TreeNode root) {
        ansList = new ArrayList<>();
        solve(root, new StringBuilder());
        Collections.sort(ansList);
        return ansList.get(0);
    }
}