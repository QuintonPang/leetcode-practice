class Solution {
public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> changes(nums.size()+1, 0);
        int current = 0;
        int q = 0;
       for(int i = 0 ; i<nums.size();i++){
                current+=changes[i];
                while(nums[i]+current>0){

                    if(q >= queries.size()) return -1;


                    int start = queries[q][0];
                    int end = queries[q][1];
                    int decrement = queries[q][2];
                    q++;
                    if(end<i){
                        continue;
                    }

                    if(start>i){
                        changes[start]-=decrement;
                    }else{
                        current-=decrement;
                    }

                        changes[end+1] += decrement;
                }
       }
       return q;
    }
};