// https://neetcode.io/problems/invert-a-binary-tree

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

// both O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode node = root.left;

        root.left = root.right;
        root.right = node;
        
        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);

        return root;
    }
}


// both O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left != null) {
                node.right = left;
                queue.add(left);
            }
            if(right != null) {
                node.left = right; 
                queue.add(right);
            }   
        }

        return root;
    }
}