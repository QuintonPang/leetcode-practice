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
    bool isUnivalTree(TreeNode* root) {
        stack<TreeNode*> s;
        s.push(root);
        int current = root->val;
        
        while(!s.empty()){
            TreeNode* node = s.top();
            if(node->val!=current) return false;
            s.pop();
            if(node->right)s.push(node->right);
       if(node->left)     s.push(node->left);
        }
        
        return true;
    }
};