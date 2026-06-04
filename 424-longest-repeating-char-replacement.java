class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int right = 0;
        int ans =0 ;
        int[]  chars = new int[26];
        Arrays.fill(chars,0);
        while (right<s.length()){

            chars[s.charAt(right)-'A']++;
            max =  Math.max(chars[s.charAt(right)-'A'],max);
            int remain = (right - left + 1) - max;
            if (remain > k){
                chars[s.charAt(left)-'A']--;
                left++;

            }
            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}