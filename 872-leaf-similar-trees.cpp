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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        stack<TreeNode*> s1;
        stack<TreeNode*> s2;
        if(root1)s1.push(root1);
        if(root2) s2.push(root2);
        TreeNode* leaf1 = getLeaf(s1);
        TreeNode* leaf2 = getLeaf(s2);
        while(leaf1 && leaf2){
            
            // if(!leaf1 || !leaf2 ) return false;
            if(leaf1->val != leaf2->val) return false;
            leaf1 = getLeaf(s1);
            leaf2 = getLeaf(s2);
        }

        return leaf1 == leaf2;
    }

    TreeNode* getLeaf(stack<TreeNode*>& s){
        while(!s.empty()){
            TreeNode* current = s.top();
            s.pop();
            if(!current->left && !current->right) return current;
            if(current->right) s.push(current->right);
            if(current->left) s.push(current->left);
        }

        return nullptr;
    }
};