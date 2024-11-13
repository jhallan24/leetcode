class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long a=b(nums,upper);
        long c=b(nums,lower-1);
        return a-c;
        
    }
    long b(int[]nums,int value){
        int left=0;
        int right=nums.length-1;
        long ans=0;
        while(left<right){
            long sum=nums[left]+nums[right];
            if(sum>value){
                right--;
            }
            else{
                ans+=right-left;
                left++;
            }
        }
        return ans;
    }
}