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
    public TreeNode createBinaryTree(int[][] descriptions) {
             Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parent);

            
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, child);

           
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            
            children.add(childVal);
        }

        
        TreeNode root = null;
        for (int key : nodeMap.keySet()) {
            if (!children.contains(key)) {
                root = nodeMap.get(key);
                break;
            }
        }

        return root;
    }

    
    public void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

   
    }