class Solution {
    public int heightChecker(int[] heights) {
        int ans=0;
        int[]arr=Arrays.copyOf(heights,heights.length);
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=heights[i]){
                ans++;
            }
        }
        return ans;
        
    }
}