class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        List<String>ans = new ArrayList<>();
            backtrack(s,ans,0,0,n);

            return ans;
    }

    private void backtrack(StringBuilder s, List<String> ans, int open , int close, int n ){
            if(close==n){
                ans.add(s.toString());
            }

            if(open<n){
                backtrack(s.append("("), ans, open+1,close, n);
                s.deleteCharAt(s.length()-1); // must undo after recusrse
            }

            if(open>close){
                backtrack(s.append(")"), ans, open,close+1, n);
                                s.deleteCharAt(s.length()-1); // must undo after recusrse

            }
    }   
}s