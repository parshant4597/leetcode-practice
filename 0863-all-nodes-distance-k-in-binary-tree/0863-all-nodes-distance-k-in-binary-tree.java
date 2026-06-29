/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void solve(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null)
            return;

        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }

        solve(root.left, map);
        solve(root.right, map);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        solve(root, map);
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(target);
        set.add(target);
        List<Integer> arr = new ArrayList<>();
        int time = 0;
        if (k == 0) {
            arr.add(target.val);
            return arr;
        }
        while (!qu.isEmpty()) {
            int size = qu.size();
            time++;

            while (size-- > 0) {
                TreeNode node = qu.poll();
                if (node.left != null && !set.contains(node.left)) {
                    if (time == k)
                        arr.add(node.left.val);
                    qu.offer(node.left);
                    set.add(node.left);
                }
                if (node.right != null && !set.contains(node.right)) {
                    if (time == k)
                        arr.add(node.right.val);
                    qu.offer(node.right);
                    set.add(node.right);
                }
                TreeNode parent = map.get(node);

                if (parent != null && !set.contains(parent)) {
                    if (time == k)
                    arr.add(parent.val);
                    qu.offer(parent);
                    set.add(parent);
                }

            }
            if (time == k)
                break;
        }
        return arr;

    }
}