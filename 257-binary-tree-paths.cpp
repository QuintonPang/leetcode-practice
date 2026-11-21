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
    vector<string> binaryTreePaths(TreeNode* root) {
        if(!root) return {};
        vector<string> ans;
        helper(root, ans,"");
        return ans;
    }
    
    void helper(TreeNode* root, vector<string>& ans, string s){
        if(!root) return;
        s += ((s.size()==0?"":"->") + to_string(root->val));
        if(!root->left && !root->right) { ans.push_back(s); return;}
        
        helper(root->left,ans,s);
        helper(root->right, ans, s);
    }
};