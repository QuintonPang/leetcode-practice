class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] changes = new int[101];
        for(int i = 0 ;i < logs.length;i++){
            int start = logs[i][0];
            int end = logs[i][1];

            changes[start-1950]++;
            changes[end-1950]--;
        }

        int max = 0;
        int current = 0;
        int year = 0 ;

        for(int i = 0;i<changes.length;i++){
            current += changes[i];
            if(current>max) { max = current; year = i + 1950;}
        }

        return year;
    }
}
