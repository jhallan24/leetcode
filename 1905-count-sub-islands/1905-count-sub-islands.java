class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int subIslandCount = 0;
 for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }

        return subIslandCount;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[0].length || grid2[x][y] == 0) {
            return true;
        }
        
        if (grid1[x][y] == 0) {
            return false;
        }

        
        grid2[x][y] = 0;
         boolean isSubIsland = true;
        isSubIsland &= dfs(grid1, grid2, x + 1, y);
        isSubIsland &= dfs(grid1, grid2, x - 1, y);
        isSubIsland &= dfs(grid1, grid2, x, y + 1);
        isSubIsland &= dfs(grid1, grid2, x, y - 1);
        
        return isSubIsland;
   
    }
}