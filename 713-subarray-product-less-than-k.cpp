class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        long long prod = 1;
        int left = 0;
        int right = 0;
        int answer = 0;
        if(k <= 1) return 0;

        while(right< nums.size()){
            prod*=nums[right];
            while(prod>=k){
                prod/=nums[left];
                left++;
                
            }
            answer += (right-left+1);

            right ++;
           

        }

        return answer;
        

    }
};