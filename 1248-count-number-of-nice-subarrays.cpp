class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int answer = 0 ;
        int count = 0;
        int left = 0;
        int odd = 0;
        for(int right = 0 ; right< nums.size();right++){
            if(nums[right] % 2 == 1) { odd++; count = 0 ; }
            while(odd == k ){
                count++;
                if(nums[left] % 2 == 1) odd--;
                left++;
            }
            answer+=count;
        }return answer;
    }
};