class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(right>left){
            while(right>left  && !Character.isLetterOrDigit(s.charAt(right))){
                    right--;
            }
            while(right>left && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }



            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
              
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}