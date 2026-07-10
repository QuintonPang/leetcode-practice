class Solution {
    public int orangesRotting(int[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;

       int freshCount = 0;
       int minutes = 0;
       Queue<int[]> queue = new ArrayDeque<>();

       for(int r = 0; r<rows;r++){
            for(int c = 0; c<cols;c++){
                int orange = grid[r][c];
                if(orange == 1) freshCount++;
                if(orange == 2) queue.offer(new int[]{r,c});
            }
       }

       if(freshCount == 0) return 0;
       while(!queue.isEmpty()){
            int size = queue.size();
            int[][] dirs = { {0,1}, {1,0}, {0,-1}, {-1,0}};
            boolean hasRottenNeighbour = false;
            for(int i = 0 ; i< size; i++){
                int[] orangeCoords = queue.poll();
                for(int[]dir: dirs){
                    int newR = orangeCoords[0] + dir[0];
                    int newC = orangeCoords[1] + dir[1];
                    if(newR<0 || newR >= rows || newC < 0 || newC >= cols){
                        continue;
                    }
                    if (grid[newR][newC] == 0 || grid[newR][newC] == 2) continue;

                    if (grid[newR][newC] == 1){
                        freshCount -- ;
                        hasRottenNeighbour = true;
                        grid[newR][newC] = 2;
                        queue.offer(new int[]{newR, newC});
                    }
                   
                }
            }
                           if(hasRottenNeighbour) minutes++;

       }

       if(freshCount>0) return -1;
       else return minutes;
    }
    
}
