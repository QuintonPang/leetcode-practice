import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 17: Letter Combinations of a Phone Number
 * * This class provides a solution to find all possible letter combinations
 * that a given string of digits (from 2 to 9) could represent.
 * * Time Complexity: O(4^N * N), where N is the length of the digits string.
 * Space Complexity: O(N) for the recursion stack and StringBuilder.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        // Edge case: empty input digits string
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        // Mapping from digit characters to their corresponding letters
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        
        // Initiate the backtracking exploration
        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);
        
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
        // Base case: if the current combination matches the target length, save a snapshot of it
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        // Get letters corresponding to the current digit
        String letters = digitToLetters.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);                                           // 1. Choose
            backtrack(digits, idx + 1, comb, res, digitToLetters);         // 2. Explore
            comb.deleteCharAt(comb.length() - 1);                          // 3. Un-choose (Backtrack)
        }
    }    
}
