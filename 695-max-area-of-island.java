class Solution {
    
   
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for(int r = 0 ; r< grid.length;r++){
            for(int c =0 ; c<grid[r].length;c++){
                if(grid[r][c]==0) continue;
                answer = Math.max(answer, dfs(grid,r,c));
            }
            
            
        }
        
        return answer;
    }
    
    int dfs(int grid[][], int r, int c){
        
        if(c>=grid[0].length || c<0|| r>=grid.length|| r<0) return 0;
        if(grid[r][c]==0) return 0 ;
        grid[r][c] = 0;
        
        return 1 + dfs(grid, r+1,c) +  dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid,r, c-1) ;
        
    }
}