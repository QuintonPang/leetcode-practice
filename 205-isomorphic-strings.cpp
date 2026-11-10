class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> m;
        unordered_map<char, char> n;
        for(int i = 0 ;i <s.length(); i++){
                char c1= s[i];
                char c2 = t[i];
                if(!m.count(c1) ){
                        m[c1] = c2;
                }else{
                    
                    if(m[c1] != c2) return false;
                }

                if(!n.count(c2) ){
                        n[c2] = c1;
                }else{
                    
                    if(n[c2] != c1) return false;
                }
        }
        return true;
    }
};