class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> result = new ArrayList<>();
        
        int steps = 1; 
        int dirIndex = 0; 
        
        result.add(new int[]{rStart, cStart});
        
        while (result.size() < rows * cols) {
            for (int i = 0; i < 2; i++) { 
                for (int j = 0; j < steps; j++) {
                    rStart += directions[dirIndex][0];
                    cStart += directions[dirIndex][1];
                    
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result.add(new int[]{rStart, cStart});
                    }
                }
                dirIndex = (dirIndex + 1) % 4; 
            }
            steps++;
        }
        
        
        return result.toArray(new int[result.size()][]);
    }
    
    
    
    private static void printResult(int[][] result) {
        for (int[] coord : result) {
            System.out.println("[" + coord[0] + "," + coord[1] + "]");
        }
        System.out.println();
    }
}