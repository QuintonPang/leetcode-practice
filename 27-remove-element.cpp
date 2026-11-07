class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int curr = 0;
        int ans = 0;
        for(int num:nums){
            if (num == val){
            
            }else{
                nums[curr] = num;
                curr ++;
                ans++;
            }
        }
        
        return ans;
    }
};