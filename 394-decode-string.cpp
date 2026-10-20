class Solution {
public:
    string decodeString(string s) {
        stack<string> stringStack;
        stack<int> numberStack;
        string currentS = "";
        int currentNumber = 0;
        for(char c:s){
            if(isdigit(c)){
                currentNumber = currentNumber * 10 + (c - '0');
            }else{
                if(c == '['){
                    stringStack.push(currentS);
                    numberStack.push(currentNumber);
                    currentS = "";
                    currentNumber = 0;
                }else if(c==']'){
                             string prev = stringStack.top();
                     
                            stringStack.pop();
                       

                    for (int i = 0; i < numberStack.top(); i++) {
    prev += currentS;

}
                                        numberStack.pop();

                                    
    currentS = prev;
                }else{
                    currentS += c;
                }
            }
        }
        return currentS;

    }
};