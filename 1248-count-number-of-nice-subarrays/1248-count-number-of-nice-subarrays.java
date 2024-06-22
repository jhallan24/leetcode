class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int tsa=0;
        int odd=0;
        int even=0;
        int start=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]%2==1){
                odd++;
            }
            if(odd==k){
                even=0;
                while(odd==k){
                    odd=odd-nums[start]%2;
                    even++;
                    start++;
                }
            }
            tsa=tsa+even;
        }
        return tsa;
    }
}