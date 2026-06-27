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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
  if (root==null) return ans;
        
        
        
        Queue <TreeNode>q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int queueSize = q.size();
            for(int i=0;i<queueSize;i++){
                TreeNode num = q.poll();
                if(i==queueSize-1) ans.add(num.val);
                if(num.left!=null)q.offer(num.left);
                if(num.right!=null)q.offer(num.right);
            }
        }
        return ans;
    }
}