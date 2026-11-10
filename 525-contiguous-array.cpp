class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> m ;
        int answer = 0;
        int prefix =  0;
        m[0] = -1;
        for(int i = 0; i<nums.size();i++){
            if(nums[i] == 0 ){
                prefix--;
            }else{
                prefix ++;
            }
            
            if(m.count(prefix)){
                answer = max(answer, i - m[prefix]);
            }else{
                m[prefix] = i;
            }
        }

        return answer;
    }
};