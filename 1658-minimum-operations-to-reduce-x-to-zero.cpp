class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int need = sum - x;
        
        int current = 0;
        int count = 0;
        
        int ans = -1;
        
        int left = 0;
        for(int right = 0; right<nums.size();right++){
            count++;
             current += nums[right];
            
            while (current > need && left<=right){
                current-=nums[left];
                count--;
                left++;
                
                
            }
            cout << current<<endl;
            if(current == need) ans = max(ans, count);
        }
        return ans ==-1?-1:nums.size()-ans;
    }
};