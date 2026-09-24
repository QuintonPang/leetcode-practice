class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        map<int, int> changes;

        for(auto&flower: flowers){
            int start = flower[0];
            int end = flower[1];
            changes[start]++;
            changes[end+1]--;
        }

        vector<pair<int,int>> sortedPeople;

        for(int i = 0; i < people.size(); i++){
            sortedPeople.push_back({people[i],i});
        }

        sort(sortedPeople.begin(),sortedPeople.end());
        vector<int>answer(people.size());

        int current = 0;
        auto it = changes.begin();

        for(auto&person: sortedPeople){
            int originalIndex = person.second;
            int index = person.first;

            while(it!=changes.end()&& it->first <= index){
                current+= it->second;
                it++;
            }
            answer[originalIndex] = current;
        }

            return answer;
    }
};
