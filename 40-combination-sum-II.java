class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, candidates, 0, target, new ArrayList<>());

        return answer;
    }

    void backtrack(List<List<Integer>> answer, int[] candidates, int start, int remaining, List<Integer> current) {

        if (remaining == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        // else if(remaining<0){
        // return;
        // }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining)
                break; // stop immediately, no useless call made
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            backtrack(answer, candidates, i + 1, remaining - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}