class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int minimum = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<nums.size()){
            sum+= nums[right];
            if(sum>=target) minimum = minimum == 0 ?right-left+1 :min(minimum, right-left+1);

            while(sum - nums[left] >=target && left<right){ 
                                sum-=nums[left];
                left++; 
               minimum = minimum == 0 ?right-left+1 :min(minimum, right-left+1);

            }
            right++;
        }

        return minimum;
    }
};