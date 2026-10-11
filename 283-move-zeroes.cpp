class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int write = 0;
        for(auto& num: nums){
            if(num!=0){
                nums[write] = num;
                write++;
            }
        }
        fill(nums.begin()+write,nums.end(),0);
    }
};