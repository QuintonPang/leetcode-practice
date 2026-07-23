class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time: times){
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            graph[source].add(new int[]{destination, weight});
        }

        // shortest distance from k to i
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;

        Queue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));

        minHeap.offer(new int[]{k,0});

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // outdated node
            if(currentDistance > distance[currentNode]){
                continue;
            }

            for(int[] edge: graph[currentNode]){
                int nextNode = edge[0];
                int edgeWeight = edge[1];

                int newDistance = currentDistance + edgeWeight;

                if(newDistance < distance[nextNode]){
                    distance[nextNode] = newDistance;
                    minHeap.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        int answer = 0;
        for(int node = 1;node<=n;node++){
            if(distance[node] == Integer.MAX_VALUE){
                return -1;
            }
            answer= Math.max(answer,distance[node]);
        }

        return answer;
    }
    
}
