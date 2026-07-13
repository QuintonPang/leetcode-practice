class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int completed = 0;
        int [] preCount = new int[numCourses];

        for(int i = 0; i<numCourses;i++){
            courses.add(new ArrayList<Integer>());
        }   

        for(int i = 0; i< prerequisites.length;i++){
            int [] pre = prerequisites[i];
                courses.get(pre[1]).add(pre[0]);
                preCount[pre[0]]++;
        }

        for(int i = 0; i<courses.size();i++){
            if(preCount[i] == 0) queue.offer(i);
        }  

        while(!queue.isEmpty()){
            int curr = queue.poll();
            List<Integer> adjacents = courses.get(curr);
            for(int i = 0 ; i<adjacents.size();i++){
                preCount[adjacents.get(i)] -- ;

                if(preCount[adjacents.get(i)] == 0 )queue.offer((adjacents.get(i)));
            }
        }

        for(int i = 0; i<numCourses;i++){
            if(preCount[i] == 0) completed++;
        } 
        return completed == numCourses;

    }
}
