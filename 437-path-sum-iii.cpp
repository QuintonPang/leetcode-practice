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
    int pathSum(TreeNode* root, int targetSum) {
        
        int answer =0;
        unordered_map<long long,int>m;
        m[0] = 1;
      helper(root, targetSum, 0, m, answer);
      
        
        return answer;
    }
    
    void helper(TreeNode* node, int targetSum, long long prefixSum, unordered_map<long long,int>& m, int& answer){
        
        if(!node) return;
        prefixSum += node->val;
        answer+= m[prefixSum-targetSum];
        m[prefixSum]++;
        helper(node->left, targetSum, prefixSum,m,answer);
        helper(node->right, targetSum, prefixSum,m,answer);
        
        m[prefixSum]--;
    }
};