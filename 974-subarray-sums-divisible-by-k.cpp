class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        map<int, int> freq;
        int answer = 0;
        int prefix = 0;
        freq[0] = 1;
        int remainder = 0;
        for(auto& num: nums){
             prefix += num;
            remainder = ((prefix%k)+k)%k;
            answer+=freq[remainder];
            freq[remainder]++;
        }
        return answer;
    }
};