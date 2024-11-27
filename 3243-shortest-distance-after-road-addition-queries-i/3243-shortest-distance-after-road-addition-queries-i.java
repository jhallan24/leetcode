class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>>adlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            adlist.add(new ArrayList<>());
            adlist.get(i).add(i+1);
        }
        int[]ans=new int[queries.length];
        int a=0;
        for(int[]query:queries){
            int from=query[0],to=query[1];
            adlist.get(from).add(to);
            ans[a++]=bfs(0,n-1,adlist,n);
        }
        return ans;
    }
    private int bfs(int source,int target,List<List<Integer>>adlist,int n){
        Queue<Integer>queue=new LinkedList<>();
        int[]distance=new int[n];
        Arrays.fill(distance,-1);
        queue.add(source);
        distance[source]=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int neighbor:adlist.get(curr)){
                if(distance[neighbor]==-1){
                    distance[neighbor]=distance[curr]+1;
                    if(neighbor==target){
                        return distance[target];
                    }
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }
}