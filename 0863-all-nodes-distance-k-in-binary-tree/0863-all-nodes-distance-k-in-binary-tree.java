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

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        buildParentMap(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            if (distance == k) {

                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    result.add(current.val);
                }

                return result;
            }

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                if (current.left != null &&
                    !visited.contains(current.left)) {

                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null &&
                    !visited.contains(current.right)) {

                    queue.offer(current.right);
                    visited.add(current.right);
                }

                TreeNode parent = parentMap.get(current);

                if (parent != null &&
                    !visited.contains(parent)) {

                    queue.offer(parent);
                    visited.add(parent);
                }
            }

            distance++;
        }

        return result;
    }

    private void buildParentMap(TreeNode root, TreeNode parent) {

        if (root == null) {
            return;
        }

        if (parent != null) {
            parentMap.put(root, parent);
        }

        buildParentMap(root.left, root);
        buildParentMap(root.right, root);
    }
}