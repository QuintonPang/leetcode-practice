class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        boolean used[] = new boolean[points.length];
        int total = 0;
        Queue <int[]> minHeap = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        int edges = 0;
        minHeap.offer(new int[]{0,0});
        while(edges<points.length){
            int[] curr = minHeap.poll();
            if(used[curr[0]]) continue;
            used[curr[0]] = true;
            edges++;
            total += curr[1];

            for(int j = 0; j<points.length;j++){
                if(used[j]) continue;
                int distance = Math.abs(points[j][0] - points[curr[0]][0]) + Math.abs(points[j][1] - points[curr[0]][1]);
                minHeap.offer(new int[]{j, distance});
            }

        }

        return total;
    }
}
