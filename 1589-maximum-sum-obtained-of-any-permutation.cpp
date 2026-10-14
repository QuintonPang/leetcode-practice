class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        vector<int> changes(nums.size()+1,0);
        
        for(auto& request: requests){
            int first = request[0];
            int second = request[1];
            changes[first]+=1;
            changes[second+1]-=1;
        }
        
        vector<int>frequency(nums.size(),0);
       
       int current = 0;
       
       for(int i =0;i<nums.size();i++){
           current+=changes[i];
           frequency[i] = current;
       } 
       
       sort(frequency.begin(), frequency.end());
       
       sort(nums.begin(),nums.end());
       
       long  answer =0;
       const int MOD = 1e9 +7;
      
       for(int i =
       0; i<
       nums.size();i++){
           answer+= 1LL* frequency[i]* nums[i];
           answer%=MOD;
       }
        return answer;
    }
};