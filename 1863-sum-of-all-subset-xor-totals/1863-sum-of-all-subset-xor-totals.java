class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int nums[],int level,int current){
        if(level==nums.length)return current;
        int inc=helper(nums,level+1,current^nums[level]);
        int exc=helper(nums,level+1,current);
        return inc+exc;
    }
}