class Solution {
    public int numDecodings(String s) {
        
        if(s.length()==0||s.charAt(0)=='0') return 0;
        
        int previousOne = 1;
        int previousTwo = 1;
        
        for(int i = 2;i<=s.length();i++){
            int current = 0;
            if(s.charAt(i-1)!='0'){
                current += previousOne;
            }
            
            int twoDigitNumber = (s.charAt(i-2)-'0')* 10 + (s.charAt(i-1)-'0');
            
            if(twoDigitNumber>=10&&twoDigitNumber<=26)
        current += previousTwo;
        
        previousTwo = previousOne;
        previousOne = current;
        
        }
        return previousOne;
    
    }
}