import java.util.*;

public class Main {

    static class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    graph.putIfAbsent(c, new HashSet<>());
                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                int minLen = Math.min(w1.length(), w2.length());
                boolean foundDiff = false;

                for (int j = 0; j < minLen; j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if (c1 != c2) {
                        graph.get(c1).add(c2);
                        foundDiff = true;
                        break;
                    }
                }

                if (!foundDiff && w1.length() > w2.length()) {
                    return "";
                }
            }

            Map<Character, Integer> state = new HashMap<>();
            StringBuilder result = new StringBuilder();

            for (char c : graph.keySet()) {
                if (!dfs(c, graph, state, result)) {
                    return "";
                }
            }
            return result.reverse().toString();
        }

        boolean dfs(char c, Map<Character, Set<Character>> graph,
                    Map<Character, Integer> state, StringBuilder result) {
            if (state.getOrDefault(c, 0) == 1) return false;
            if (state.getOrDefault(c, 0) == 2) return true;

            state.put(c, 1);

            for (char neighbour : graph.get(c)) {
                if (!dfs(neighbour, graph, state, result)) {
                    return false;
                }
            }

            state.put(c, 2);
            result.append(c);

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Test 1 (expect a valid order like \"wertf\"): " + sol.alienOrder(words1));

        String[] words2 = {"z", "x"};
        System.out.println("Test 2 (expect \"zx\"): " + sol.alienOrder(words2));

        String[] words3 = {"z", "x", "z"};
        System.out.println("Test 3 (expect \"\" - cycle): " + sol.alienOrder(words3));

        String[] words4 = {"abc", "ab"};
        System.out.println("Test 4 (expect \"\" - invalid prefix order): " + sol.alienOrder(words4));

        String[] words5 = {"abc"};
        System.out.println("Test 5 (expect some permutation containing a,b,c): " + sol.alienOrder(words5));

        String[] words6 = {"wrt", "wrf", "er", "ett", "rftt", "te"};
        System.out.println("Test 6: " + sol.alienOrder(words6));
    }
}
