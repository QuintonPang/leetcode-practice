class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int left = 0;
        int current = 0;
        int answer = 0;
        int count = 0;

        for(int right = 0 ;right<nums.size();right++){
            current+=nums[right];
           

              while (left < right &&
                   (nums[left] == 0 || current > goal)) {

                if (nums[left] == 0) {
                    count++;
                } else {
                    count = 0;
                }

                current -= nums[left];
                left++;
            }
            if(current == goal) {
                answer+=count+1;

            }
        }

        return answer;

    }
};