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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        List<TreeNode> forest = new ArrayList<>();
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }
        
        dfs(root, toDeleteSet, forest);
        return forest;
    }
    
    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        node.left = dfs(node.left, toDeleteSet, forest);
        node.right = dfs(node.right, toDeleteSet, forest);
        
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        
        return node;
    }

    
    public void printForest(List<TreeNode> forest) {
        for (TreeNode root : forest) {
            printTree(root);
            System.out.println();
        }
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

   
    }