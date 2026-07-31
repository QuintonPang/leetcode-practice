class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0;i<s.length();i++){
            int odd = countFromCenter(s, i , i );
             int even = countFromCenter(s, i , i + 1);

             count += odd;
             count += even;
        }

        return count;
    }

    int countFromCenter(String s, int start, int end){
        int count = 0;
        while(start>=0 && end <s.length() && s.charAt(start) == s.charAt(end)){
            count += 1;
            start --  ;
            end ++;

        }

        return count;
    }
}
