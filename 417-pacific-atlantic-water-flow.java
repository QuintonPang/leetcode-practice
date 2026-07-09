class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][]pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();
        
        // seeding
        for(int r=0 ; r< rows; r++){
            pacific[r][0] = true;
            pacificQueue.offer(new int[]{r,0}); // left
            
            atlantic[r][cols-1] = true;
            atlanticQueue.offer(new int[]{r,cols-1}); // right
        }
        for(int c=0 ; c<cols;c++){
            pacific[0][c]=true;
            pacificQueue.offer(new int[]{0,c}); // top
            
            atlantic[rows-1][c] = true;
            atlanticQueue.offer(new int[]{rows-1, c}); // bottom
        }
        
        bfs(heights, pacific, pacificQueue)
        ;
        bfs(heights, atlantic,atlanticQueue);
        List<List<Integer>> answer = new ArrayList<>();
        
        for(int r = 0;r<rows;r++){
            for(int c =0; c<cols; c++){
                if(pacific[r][c]&&atlantic[r][c]) answer.add(Arrays.asList(r,c));
            }
        }
        
        return answer;
    }
    
    void bfs(int[][]heights, boolean[][] used, Queue<int[]> queue){
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[]dir : dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                if(newR<0||newR>=heights.length || newC <0|| newC >= heights[newR].length)continue;
                if(heights[newR][newC]<heights[r][c]) continue;
                if(used[newR][newC]) continue;
                used[newR][newC] = true;
                queue.offer(new int[]{newR,newC});
            }
        }
    }
}