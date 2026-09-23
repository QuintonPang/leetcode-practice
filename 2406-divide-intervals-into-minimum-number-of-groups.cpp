class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(),
     [](const vector<int>& a, const vector<int>& b) {
         return a[0] < b[0];
     });

    priority_queue<int, vector<int>, greater<int>> minHeap;

    for(auto& interval: intervals){
        int start = interval[0];
        int end = interval[1];

       if(!minHeap.empty() && start > minHeap.top()){
        minHeap.pop();
       }

        minHeap.push(end);
    }
    return minHeap.size();
    }
};
