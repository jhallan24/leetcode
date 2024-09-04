class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;  
        int dir = 0;  
        int maxDistSq = 0; 

        
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        
        for (int command : commands) {
            if (command == -2) {  
                dir = (dir + 3) % 4;
            } else if (command == -1) {  
                dir = (dir + 1) % 4;
            } else {  
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    
                   
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break;  
                    }

                    
                    x = newX;
                    y = newY;

                    
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                }
            }
        }

        return maxDistSq;
    
    }
}