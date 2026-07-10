class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        int INF = 2147483647;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int r = 0 ; r< rows; r++){
            for(int c = 0; c< cols; c++){
                if(rooms[r][c] == 0) queue.offer(new int[]{r,c});
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[]dir : dirs){
                int newR = current[0] + dir[0];
                int newC = current[1] + dir[1];
                if(newR< 0 || newR >= rows || newC< 0 || newC >=cols) continue;
                if(rooms[newR][newC]!= INF) continue;
                rooms[newR][newC] = rooms[current[0]][current[1]] + 1;
                queue.offer(new int[]{newR, newC});
            }
        }
    }
}
