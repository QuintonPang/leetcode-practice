class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencies = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] count = new int[numCourses];
        for(int i = 0; i< numCourses; i++){
                adjacencies.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
                adjacencies.get(prerequisites[i][1]).add(prerequisites[i][0]);
                count[prerequisites[i][0]]++;
        }
        
        Queue <Integer> queue = new ArrayDeque<>();
         for(int i = 0;i<count.length;i++){
                if(count[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            answer.add(current);
                for(int j = 0; j< adjacencies.get(current).size(); j++){
                    count[adjacencies.get(current).get(j)]--;

                    if(count[adjacencies.get(current).get(j)] == 0){
                        queue.offer(adjacencies.get(current).get(j));
                    }
                
            }
        }

       

        return answer.size()==numCourses?  answer.stream().mapToInt(Integer::intValue).toArray(): new int[0];
    }
}
