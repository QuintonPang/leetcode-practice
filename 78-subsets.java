class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0, new ArrayList<>());
        
        return result;
    }
    
    void backtrack(int[]nums, List<List<Integer>>result,int index, List<Integer> current){
        if(index==nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        current.add(nums[index]);
        
        backtrack(nums,result,index+1, current);
        
        current.remove(current.size()-1);
        
        backtrack(nums,result,index+1, current);
        
        
    }
}