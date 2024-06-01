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
    private int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        dfs(root);
        return moves;
        
    }
    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=dfs(node.left);
        int right=dfs(node.right);
        int total=node.val+left+right-1;
        moves=moves+Math.abs(total);
        return total;
    }
}