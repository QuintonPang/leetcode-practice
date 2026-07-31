class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        
        int max = 1;
        
        int start = 0;
        for(int i=0;i<s.length();i++){
            int odd = getLen(s,i,i);
            int even = getLen(s,i,i+1);
            
            int current = Math.max(odd,even);
            if(current>max){
                max = current;
                start = i - (current - 1) / 2;
            }
        }
        
        return s.substring(start,start+ max);
    }

    int getLen(String s, int st, int e){
        
        while(st>=0&&e<s.length()&& s.charAt(st)== s.charAt(e)){
            st--;
            e++;
            
        }
        
        return e-st-1;
    }
}