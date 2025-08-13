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
    private int maxLen = 0;

    // 1 means right, 0 means left. Dir indicates the current direction.
    private void solve(TreeNode root, int dir, int currLen){
        if(root==null) return;

        // Keep track of the maximum length.
        maxLen = Math.max(maxLen, currLen);
        
        // If current dir is right, go to left with incremented currLen;
        // or go to right w/ currLen=1 (a new path starting from the current node).
        if(dir==1){
            solve(root.left, 0, currLen+1);
            solve(root.right, 1, 1);
        }else{
            solve(root.right, 1, currLen+1);
            solve(root.left, 0, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        solve(root,0,0);
        solve(root,1,0);
        return maxLen;
    }
}