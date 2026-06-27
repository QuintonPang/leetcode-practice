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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Queue <TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List <Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode num = q.poll();
                currentLevel.add(num.val);
                if(num.left!=null )q.offer(num.left);
                if(num.right!=null)q.offer(num.right);
            }
            
            ans.add(currentLevel);
        }
        return ans;
    }
}