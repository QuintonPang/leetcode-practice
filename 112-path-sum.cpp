/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        return search(0, root, targetSum);
    }

    bool search(int current, TreeNode* root , int targetSum ){
            if(!root) return false;
            current += root->val;

            if(current == targetSum && !root->left && !root->right) return true;
            return search(current, root->right, targetSum) || search(current, root->left, targetSum);
    }
};