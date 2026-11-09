class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while(right < nums.size()){
            if(nums[right]==0){
                
            
            if(zeros<k){
            answer = max(answer,right-left+1);
            right ++;
            zeros++;
            }else{
                if(nums[left]==0) zeros--;
                left ++;
            
                
            }
            }else{
                
                answer = max(answer,right-left+1);
                right++;
            }
        }
        return answer;
    }
};