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
    int minDepth(TreeNode* root) {
        if(!root) return 0;
       queue<TreeNode*> q ;
        q.push(root);
        int depth = 0;
       while(!q.empty()){
        int size = q.size();
        int i = 0;
        depth++;
        while(i<size){
            
            
            TreeNode* current = q.front();
            q.pop();
            if(!current->left && ! current->right) return depth;
            if(current->left)q.push(current->left);
            if(current->right)q.push(current->right);
            i++;
        }
        
           
            
       }
       return depth;
    }

    
};