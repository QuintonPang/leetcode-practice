class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        if(sum>num*9){
            return "";
        }
        int current = 0;
        string answer = "";
        int remaining = sum;

        while(current< num){
            int digit = remaining - 9 >= 0 ? 9 : remaining;
            answer  += char('0' + digit);
            remaining -= digit;
            current ++;
        }

        return answer;
    }
};