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

    int idx ;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        return solve (postorder , inorder , 0 , inorder.length-1);
    }

    private TreeNode solve (int[] postorder , int[] inorder , int start , int end){

        if(start > end){
            return null;
        }

        int rootVal = postorder[idx];

        int i = start;

        while( i <= end){
            if(inorder[i] == rootVal){
                break;
            }

            i++;
        }

        idx--;

        TreeNode root = new TreeNode(rootVal);

        root.right = solve(postorder , inorder , i + 1 , end);

        root.left = solve(postorder , inorder , start , i-1);

        

        return root;
}
}