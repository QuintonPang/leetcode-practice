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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> current;
        helper(current, 0, targetSum, root, ans);
        return ans;
    }

    void helper(vector<int>& current, int sum, int targetSum, TreeNode* node, vector<vector<int>>& ans){
        if(!node) return;
        current.push_back(node->val);
        sum += node->val;
        if(!node->left && ! node->right){
            if(sum == targetSum){
                ans.push_back(current);
            }
            current.pop_back();
            return;
        }
        if(node->left) helper(current, sum, targetSum, node->left, ans);
        if(node->right) helper(current, sum, targetSum, node->right,ans );
        current.pop_back();

    }
};