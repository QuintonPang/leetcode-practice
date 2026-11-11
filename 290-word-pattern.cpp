class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char, string> m1; 
        unordered_map<string, char>m2;
        stringstream newS(s);
        string current;
    int i = 0;
        while(newS >> current){
            if(i>=pattern.size()) return false;
            if(m2.count(current)) {
                if(m2[current]!= pattern[i]) return false;
            }

             if(m1.count(pattern[i])) {
                if(m1[pattern[i]]!= current) return false;
            }
            
            m2[current] = pattern[i];
            m1[pattern[i]] = current;
            
            i++;
        } 
        
        return i == pattern.size();
    }
};