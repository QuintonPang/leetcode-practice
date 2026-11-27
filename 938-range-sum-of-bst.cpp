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
    int rangeSumBST(TreeNode* root, int low, int high) {
        stack<TreeNode*> s;
        int sum = 0;
        s.push(root);
        while(!s.empty()){
            TreeNode* current = s.top();
            s.pop();
            if(current->val <= high && current->val >= low) sum+=current->val;
            if(current->right && current->val < high) s.push(current->right);
            if(current->left && current-> val > low) s.push(current->left);
        }
        return sum;
    }
};