class Solution {
    int[]rowDirection={1,0,0,-1};
    int[]colDirection={0,1,-1,0};
    int[][]minObstacles;
    public int minimumObstacles(int[][] grid) {
        minObstacles=new int[grid.length][grid[0].length];
        for(int[]arr:minObstacles){
            Arrays.fill(arr,Integer.MAX_VALUE);
            }
        return bfs(grid);
        
    }
    public int bfs(int[][]grid){
        minObstacles[0][0]=0;
        Deque<int[]>deque=new LinkedList<>();
        deque.add(new int[]{0,0,0});
        while(!deque.isEmpty()){
            int[]curr=deque.remove();
            int obstacles=curr[0],row=curr[1],col=curr[2];
            for(int i=0;i<4;i++){
                int newrow=row+rowDirection[i];
                int newcol=col+colDirection[i];
                if(isValid(newrow,newcol)&& minObstacles[newrow][newcol]==Integer.MAX_VALUE){
                    if(grid[newrow][newcol]==1){
                        deque.addLast(new int[]{1+obstacles,newrow,newcol});
                        minObstacles[newrow][newcol]=obstacles;
                    }
                    else{
                        deque.addFirst(new int[]{obstacles,newrow,newcol});
                        minObstacles[newrow][newcol]=obstacles;
                    }
                }
            }
        }
        return minObstacles[grid.length-1][grid[0].length-1];
    }
    boolean isValid(int row,int col){
        return row>=0 && col>=0 && row<minObstacles.length && col<minObstacles[0].length;
    }
    
}