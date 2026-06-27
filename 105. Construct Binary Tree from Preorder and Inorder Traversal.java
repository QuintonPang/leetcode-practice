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

    int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length ; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0 , inorder.length-1);

    }

    // inorderLeft and inorderRight represent the boundary or the inorder array
    TreeNode build(int[] preorder, int inorderLeft, int inorderRight){
        if(inorderLeft > inorderRight){
            return null;
        }

        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInInorder = inorderIndexMap.get(rootVal);
        root.left = build(preorder, inorderLeft, rootIndexInInorder-1);
        root.right = build(preorder, rootIndexInInorder+1, inorderRight);

        return root;
    }
}