class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        
        backtrack(candidates, target , target, 0, new ArrayList<>(), answer);
        
        return answer;
        
      }  
        
        void backtrack(int[] candidates,int remaining, int target, int start, List<Integer> current, List<List<Integer>> answer){
            if(remaining==0){
               answer.add(new ArrayList<>(current)); return;
            }else if(remaining<0){
               return;
            }
            
            
      for(int i=start;i<candidates.length;i++){
        int new_remaining = remaining - candidates[i];  current.add(candidates[i]);       backtrack(candidates,new_remaining,target,i,current,answer);
        current.remove(current.size()-1)
          ;        }     
                   
     
        }
    
}