class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int ans=0;
        int low=1;
        int high=(int)Math.ceil(position[position.length-1]/(m-1.0));
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ispossible(mid,position,m)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
        
        }
    boolean ispossible(int space,int[]position,int m){
        int prevball=position[0];
        int ballplaced=1;
        for(int i=1;i<position.length && ballplaced<m;i++){
            int currposition=position[i];
            if(currposition-prevball>=space){
                ballplaced++;
                prevball=currposition;
            }
        }
        return ballplaced==m;
        
    }
}