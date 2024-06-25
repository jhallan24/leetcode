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
    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }
    int parent=0;
    void traversal(TreeNode root){
        if(root==null)return;
        traversal(root.right);
        root.val=root.val+parent;
        parent=Math.max(root.val,parent);
        traversal(root.left);
    }
}