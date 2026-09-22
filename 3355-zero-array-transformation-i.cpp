class Solution {
public:
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> changes(nums.size()+1, 0);

        for(auto& query: queries){
            int start = query[0];
            int end = query[1];
            changes[start]--;
            changes[end+1]++; 
        }

        int current = 0;

        for(int i = 0;i< nums.size(); i++){
            current += changes[i];
          
            if(-current<nums[i]) return false;
        }

        return true;
    }
};