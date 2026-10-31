class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int mini = INT_MAX;
        int secondMin = INT_MAX;
        
        for(auto& num: nums){
            if(num > secondMin)return true;
            else if (num > mini) {
                secondMin = min(num, secondMin);
            } else{
                mini = min(num,mini);
                
                
            }
        }
        
        return false;
    }
};