class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int left = 0;
        int max  = 0;
        for (int i =0; i< s.toCharArray().length;i++){
            while(characters.contains(s.charAt(i))){
                characters.remove(s.charAt(left));

                left++;
            }
            characters.add(s.charAt(i));
            max = Math.max(i-left+1,max);
        }   
return max;
    }
}