class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        string path;

        dfs(root, path, ans);

        return ans;
    }

    void dfs(TreeNode* root, string& path, vector<string>& ans) {
        if (!root) return;

        // Remember the previous string length
        int oldSize = path.size();

        if (!path.empty()) path += "->";
        path += to_string(root->val);

        if (!root->left && !root->right) {
            ans.push_back(path);
        } else {
            dfs(root->left, path, ans);
            dfs(root->right, path, ans);
        }

        // Undo the changes before returning
        path.resize(oldSize);
    }
};