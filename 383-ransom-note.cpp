class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> cArr (26,0);
        for(char c : magazine){
            cArr[c-'a']++;
        }

         for(char c : ransomNote){
            cArr[c-'a']--;
        }

        for(int i = 0;i<cArr.size();i++){
            if(cArr[i] < 0) return false;
        }
        return true;
    }
};