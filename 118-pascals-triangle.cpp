class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> answer;

        for(int i = 0;i < numRows; i++){
            if(i==0){ answer.push_back({1}); continue;}
            else if(i==1){answer.push_back({1,1}); continue;}
            vector<int> current;
            current.push_back(1);
            for(int j = 0; j<i-1;j++){
                current.push_back(answer[i-1][j] + answer[i-1][j+1] );
            }
            current.push_back(1);

           answer.push_back(current);
        }

        return answer;
    }
};