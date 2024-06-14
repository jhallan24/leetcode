class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max=nums[0];
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[]fre=new int[max+nums.length];
        for(int num:nums){
            fre[num]++;
        }
        int ans=0;
        for(int i=0;i<fre.length;i++){
            if(fre[i]<=1)continue;
            int duplicate = fre[i]-1;
            fre[i+1]+=duplicate;
            ans=ans+duplicate;
        }
        return ans;
        
    }
}