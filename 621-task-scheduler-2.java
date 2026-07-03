class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxCount = 0;
    
        for(char task : tasks){
            freq[task-'A']++;
        }

        for(int f:freq){
           maxFreq = Math.max(maxFreq, f);
        }

         for(int f:freq){
           if(f==maxFreq) maxCount++;
        }

        int time = (n+1) * (maxFreq-1) + maxCount;

        return Math.max(time, tasks.length);
    }
}
