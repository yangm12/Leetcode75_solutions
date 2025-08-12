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
    private int maxVal = -Integer.MAX_VALUE;
    private int ctr = 0;

    // private void DFS(TreeNode node){
    //     if(node == null) return;

    //     int pm = cm;
    //     cm = Math.max(cm, node.val);

    //     if(node.val == cm) ctr++;

    //     DFS(node.left);
    //     DFS(node.right);

    //     cm = pm;
    // }

    private void DFS(TreeNode node, int maxVal){
        if (node==null) return;

        if(node.val>=maxVal){
            ctr++;
            maxVal = node.val;
        }

        if(node.left!=null){
            DFS(node.left, maxVal);
        }

        if(node.right!=null){
            DFS(node.right, maxVal);
        }
    }

    public int goodNodes(TreeNode root) {
        DFS(root, maxVal);
        return ctr;  
    }
}