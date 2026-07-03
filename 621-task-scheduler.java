class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        Queue<Integer> maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
        for(char task : tasks){
            freq[task-'A']++;
        }

        for(int f:freq){
            if(f>0)
            maxHeap.offer(f);
        }

        int time = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                int curr = maxHeap.poll();
            
                curr --;
                if(curr>0) temp.add(curr);
                }
                time++;

                if(maxHeap.isEmpty() && temp.isEmpty()) break; // last
                
            }
            for(int f: temp)
           maxHeap.offer(f);
        }

        return time;
    }
}
