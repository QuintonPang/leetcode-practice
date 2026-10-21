class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> s;
        s[0] = 1;
        int sum = 0;
        int answer = 0;
        for(int num: nums){
            sum+= num;
            if(s.count(sum-k)) {
                answer+= s[sum-k];
            }
            s[sum]++;
        }

        return answer;
    }
};