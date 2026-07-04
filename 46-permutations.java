class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        backtrack(nums, new ArrayList<>(),new boolean[nums.length], answer);
        
        return answer;
    }
    
    void backtrack(int[]nums, List<Integer> current, boolean[] used, List<List<Integer>> answer){
        if(current.size()== nums.length){
            answer.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=0; i<nums.length;i++){
           if(used[i]) continue; current.add(nums[i]);
            used[i] = true;
            
            backtrack(nums,current,used,answer);
            
            current.remove(current.size()-1);
            
            used[i] = false;
            
        }
    }
}