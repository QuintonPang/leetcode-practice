class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int [] charArr = new int[26];
        int [] charArr2 = new int[26];

        for(int i = 0;i<s1.length();i++){
            charArr[ s1.charAt(i) - 'a'] ++;
            charArr2[s2.charAt(i)  - 'a'] ++;
        }

        for(int j =  0 ;j< s2.length() - s1.length() ;j++){
            if(isMatch(charArr2, charArr)) return true;
            charArr2[s2.charAt(j+s1.length())  - 'a'] ++;
            charArr2[s2.charAt(j) - 'a'] -- ;
        }
            if(isMatch(charArr2, charArr)) return true;
            return false;
    }

    public Boolean isMatch(int [] arr1, int[] arr2){
         for(int i = 0;i<arr1.length;i++){
            if (arr1[i] !=    arr2[i] )
            return false;
        }

        return true;
    }
}