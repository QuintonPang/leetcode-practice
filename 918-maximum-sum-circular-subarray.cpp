class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int sum = 0;
        for (auto& num:  nums){
            sum += num;
        }
        int totalMin = nums[0];
        int currentMin = nums[0];
        int totalMax = nums[0];
        int currentMax = nums[0];
        
        for(int i =1 ; i<nums.size();i++){
            currentMin = min(nums[i],currentMin+nums[i]);
            totalMin = min(totalMin, 
        currentMin);
           currentMax = max(nums[i],currentMax+nums[i]);
            totalMax = max(totalMax, currentMax);
        }
        if (totalMax < 0 ) return totalMax;
        return max(totalMax, sum - totalMin);
    }
};