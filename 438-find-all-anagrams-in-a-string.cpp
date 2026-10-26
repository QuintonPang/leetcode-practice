class Solution {
public:
    vector<int> findAnagrams(string s, string p) {

        if(p.length()>s.length()) return vector<int>();
        vector<int> need (26, 0);
        vector<int> window (26,0);
        vector<int> answer;

        int left = 0;
        int right = p.length() -1;

        for(char c: p){
            need[c-'a']++;
        }

        for(int i = left;i<=right; i++){
            window[s[i] - 'a']++;
        }
            if(window == need) answer.push_back(0);

        while(right<s.length()-1){
            left++;
            right++;
            window[s[left-1] - 'a']--;
            window[s[right] - 'a']++;
            if(window == need) answer.push_back(left);

        }

        return answer;

    }
};