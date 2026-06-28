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
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        gain(root);
        return max;
    }
    
    int gain(TreeNode node){
        if(node==null) return 0; // base case
        int leftGain = Math.max(gain(node.left),0); // dont take negative valued
        int rightGain = Math.max(gain(node.right),0);
        
        int total = node.val + leftGain + rightGain;
        
        max = Math.max(total,max);

        return node.val + Math.max(leftGain, rightGain);
    }
}