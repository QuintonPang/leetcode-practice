class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
        int carry = 0;
        for(int i = digits.size()-1;i>=0;i--){
            int total =0;
            
            
            
            if(i==digits.size()-1){
                 total = digits[i]+1;
            
                
            }else{
                total = digits[i]+carry;
            }
            if(total>=10) carry =1;
            else carry = 0;
            digits[i] = total % 10;
        }
        
        if(carry>0) digits.insert(digits.begin(),carry);
        return digits;
    }
};