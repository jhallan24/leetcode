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
    private static TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue || root.val == destValue) {
            return root;
        }

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    
    private static boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        if (findPath(root.left, value, path)) {
            path.append('L');
            return true;
        }
        if (findPath(root.right, value, path)) {
            path.append('R');
            return true;
        }
        return false;
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        findPath(lca, startValue, pathToStart);

        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, destValue, pathToDest);

        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        
        result.append(pathToDest.reverse().toString());

        return result.toString();
    }

    
    }
