class Solution {
    public long findScore(int[] nums) {
        long ans=0;
        boolean[]visited=new boolean[nums.length];
        PriorityQueue<int[]>minHeap=new PriorityQueue<>((a1,a2)->{
            
        
                                                        if(a1[0]==a2[0])return a1[1]-a2[1];
                                                        return a1[0]-a2[0];
        });
          for(int i=0;i<nums.length;i++){
              minHeap.add(new int[]{nums[i],i});
          }                                              
        while(!minHeap.isEmpty()){
            int[]temp=minHeap.remove();
            int num=temp[0];
            int idx=temp[1];
            if(!visited[idx]){
                ans=ans+num;
                if(idx>0)visited[idx-1]=true;
                if(idx<nums.length-1)visited[idx+1]=true;
            }
        }
        return ans;
    }
}