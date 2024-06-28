class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
       long ans=0;
        for(int[]road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        for(int i=n-1;i>=0;i--){
            ans=ans+(long)degree[i]*(long)(i+1);
        }
        return ans;
    }
    }
