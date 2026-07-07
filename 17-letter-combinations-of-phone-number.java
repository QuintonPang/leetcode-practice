class Solution {

      String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if(digits.length()== 0 ) return answer;
      


      backtrack(new StringBuilder(), answer, 0, digits);

      return answer;
    }

    void backtrack(StringBuilder s, List<String>answer, int index, String digits){
        if(index == digits.length()) {
            answer.add(s.toString());
            return;
        }

        String letters = map[Character.getNumericValue(digits.charAt(index))];

        for(char letter: letters.toCharArray()){
            s.append(letter);
            backtrack(s, answer, index + 1, digits);
            s.deleteCharAt(s.length()-1);

        }

    }
}
