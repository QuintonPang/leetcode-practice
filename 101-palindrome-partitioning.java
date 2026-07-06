class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();

        backtrack(s, answer, new ArrayList<>(), 0);

        return answer;
    }

    void backtrack(String s,  List<List<String>> answer, List<String> current, int start){
        if(start == s.length()){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int i =start; i<s.length(); i++){
            String part = s.substring(start, i+1);
            if(isPalindrome(part)){
                current.add(part);
                backtrack(s, answer, current, i+1);
                current.remove(current.size()-1);
            }
           
        }
    }

    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left)!= s.charAt(right)) return false;
            left++;
            right -- ;
        }

        return true;
    }
}
