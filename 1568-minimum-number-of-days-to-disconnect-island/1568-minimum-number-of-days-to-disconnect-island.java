class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minDays(int[][] grid) {
           if (!isConnected(grid)) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1; 
                }
            }
        }
        
        
        return 2;
    }
    
    private boolean isConnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int landCount = 0;
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCount++;
                    if (landCount == 1) {
                        dfs(grid, visited, i, j);
                    }
                }
            }
        }
        
       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return false;
                }
            }
        }
        
        return landCount > 0;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        for (int[] direction : directions) {
            dfs(grid, visited, i + direction[0], j + direction[1]);
        }
    }
    
   
    }