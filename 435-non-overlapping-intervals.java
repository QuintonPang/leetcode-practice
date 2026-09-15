class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        
        int currentEnd = intervals[0][1];
        int delete = 0;
        
        for(int i = 1;i <intervals.length;i++){
            int newStart = intervals[i][0];
            
            if(newStart<currentEnd){
                delete++;
            }else{
                currentEnd = intervals[i][1];
            }
        }
        return delete;
    }
}