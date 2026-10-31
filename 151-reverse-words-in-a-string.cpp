class Solution {
public:
    string reverseWords(string s) {
        int read = 0;
        int write = 0;
        while(read<s.length()){
            
            while(read<s.length() && s[read] == ' '){
              
                read++;
            }

            if(read >= s.length()) break ; // trailing whitespzce

            if(write>0){
                s[write++] = ' ';
            }

            while(read<s.length() && s[read] != ' '){
                s[write] = s[read];
                write++;
                read++;
            }

        }
        s.resize(write);

        reverse(s.begin(),s.end());

        int curr = 0;
        for(int i = 0 ;i<=s.length();i++){
            if(i == s.length() || s[i]==' '){
                reverse(s.begin()+curr, s.begin()+i);
                curr = i + 1;
            }
        }
        return s;
    }
};